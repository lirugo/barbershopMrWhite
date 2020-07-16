package com.lirugo.barbershopMrWhite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SettingController {

    private String emojiScissor = "\u2702";
    private String emojiClock = "\uD83D\uDD50";
    private String emojiMoney = "\uD83D\uDCB0";

    @Value("${setting.key}")
    private String KEY;

    @Value("${telegram.bot.chat.id}")
    private String tgChatId;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BarberRepo barberRepo;

    @Autowired
    private Bot bot;

    @GetMapping("/setting")
    public String setting(
            Model model,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "barberId", required = false) Integer barberId
    ){
        if(!KEY.equals(key) || barberId == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Barber barber = new Barber();
        barber.setId(barberId);

        if(barberId == 1)
            barber.setName("Vadim");
        else if (barberId == 2)
            barber.setName("Andrew");

        model.addAttribute("barber", barber);
        model.addAttribute("schedule", scheduleRepo.findAllByBarberIdOrderByDayDesc(barberId));

        return "setting";
    }

    @GetMapping("/schedule")
    @ResponseBody
    public List<Schedule> getSchedule(@RequestParam Integer barberId){
        return scheduleRepo.findAllByBarberIdOrderByDayDesc(barberId);
    }

    @PostMapping("/schedule/update")
    @ResponseBody
    public void updateSchedule(@RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        Schedule[] schedules = new Schedule[0];
        try {
            schedules = mapper.readValue(body, Schedule[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for(Schedule sc : schedules)
            scheduleRepo.save(sc);
    }

    @PostMapping("/schedule/add")
    @ResponseBody
    public Schedule addSchedule(@RequestBody Schedule schedule){
        return scheduleRepo.save(schedule);
    }

    @PostMapping("/schedule/notification")
    @ResponseBody
    public void notification(@RequestBody Schedule schedule){
        StringBuilder sb = new StringBuilder();
        sb
                .append("РАСПИСАНИЕ" + "\n")
                .append("БАРБЕР: ").append(barberRepo.getOne(schedule.getBarberId()).getName()).append("\n")
                .append("ДАТА: ").append(dateFormat(schedule.getDay())).append("\n");

        sb.append("---------------------------------------").append("\n");

        System.out.println();
        bot.sendMsg(tgChatId, sb.toString());
    }

    @PostMapping("/order")
    @ResponseBody
    public Order order(@RequestBody Order order){
        Barber barber = barberRepo.getOne(order.getBarber().getId());
        order = orderRepo.save(order);

        //Collect tg msg
        StringBuilder sb = new StringBuilder();

        sb.append(emojiScissor + emojiScissor + emojiScissor + "\n");
        sb.append("НОМЕР ЗАКАЗА: ").append(order.getId()).append("\n");
        sb.append("БАРБЕР: ").append(barber.getName()).append("\n");
        sb.append("---------------------------------------").append("\n");
        sb.append("КЛИЕНТ: ").append(order.getName()).append("\n");
        sb.append("ТЕЛЕФОН: ").append(order.getPhone()).append("\n");
        sb.append("ДАТА: ").append(order.getDay()).append("\n");
        sb.append("ВРЕМЯ: ").append(order.getTime()).append("\n");
        sb.append("НАПОМНИТЬ: ").append(order.getReminder()).append("\n");
        if(order.getComment() != null)
            sb.append("КОМЕНТАРИЙ: ").append(order.getComment()).append("\n");

        bot.sendMsg(tgChatId, sb.toString());

        //Set time as busy
        for(Schedule s: scheduleRepo.findAllByBarberIdOrderByDayDesc(barber.getId())){
            if(dateFormat(s.getDay()).equals(order.getDay())){

                scheduleRepo.save(s);
            }
        }

        return order;
    }

    private String dateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
