const CURRENT_DAY = new Date().toISOString().split('T')[0]

let burgerMenu = document.querySelector(".burger-menu")
let menu = document.querySelector(".menu")


// let unlock = true



function openBurgerMenu () {
    if (burgerMenu.classList.contains("active")) {
        burgerMenu.classList.remove("active")
        burgerMenu.innerHTML = `<img src="img/menu.svg" alt="">`
        menu.classList.toggle("active-menu")
        menu.classList.toggle("menu")
    }else {
        burgerMenu.classList.add("active")
        burgerMenu.innerHTML = `<img src="img/close.svg" alt="">`
        menu.classList.toggle("active-menu")
        menu.classList.toggle("menu")
    }
}
burgerMenu.onclick = function() {
    openBurgerMenu()
}
window.onresize = function(event) {
    let windowWidth = window.innerWidth
    if (windowWidth >= 930 && menu.classList.contains("active-menu")) {
        menu.classList.add("menu")
        menu.classList.remove("active-menu")
        burgerMenu.classList.remove("active")
        burgerMenu.innerHTML = `<img src="img/menu.svg" alt="">`
    }
    // if (windowWidth > 700 && windowWidth <= 1050) {
    //     slidesToShow = 2
    //     itemWidth = container.clientWidth / slidesToShow
    // } 
    // if (windowWidth <= 700) {
    //     slidesToShow = 1
    //     itemWidth = container.clientWidth / slidesToShow
    // }
}
function initMap() {
    let addressMrWhite = {lat: 50.437280, lng: 30.350688}
    let map = new google.maps.Map(
        document.querySelector(".map"), {
            zoom: 18,
            center: addressMrWhite,
            options:{
                gestureHandling: 'cooperative'
            }
        }
    )
    let marker = new google.maps.Marker(
        {
            position: addressMrWhite,
            map: map,
            icon: "img/logo.mapMarker.jpg"
        }

    )
}
const recordButtonsOpen = document.querySelectorAll(".record-button")

if (recordButtonsOpen.length > 0) {

    for (let i = 0; i < recordButtonsOpen.length; i++) {
        const recordButtonOpen = recordButtonsOpen[i]
        recordButtonOpen.addEventListener("click", function (e) {
            const recordButtonPopup = document.querySelector(".record-button-popup")
            popupRecordingOpen (recordButtonPopup)
        })
    }
}

const popupCloseIcon = document.querySelectorAll(".close-recording-popup")

if (popupCloseIcon.length > 0) {
    for (let i = 0; i < popupCloseIcon.length; i++) {
        const element = popupCloseIcon[i]
        element.addEventListener("click", function (e) {
            popupRecordingClose(element.closest(".record-button-popup"))
        })
    }
}
function popupRecordingOpen (openPopup) {
    if (openPopup) {
        const popupRecordingActive = document.querySelector(".record-button-popup.open")
        if (popupRecordingActive) {
            popupRecordingClose(popupRecordingActive)
        }
    }
    openPopup.classList.add("open")
    openPopup.addEventListener("click", function (e) {
        if (!e.target.closest(".record-button-popup-content")) {
            popupRecordingClose(e.target.closest(".record-button-popup"))
        }

    })
}

function popupRecordingClose (popupRecordingActive) {

    popupRecordingActive.classList.remove("open")

}


const openReviewPopup = document.querySelector(".open-review-form")

openReviewPopup.addEventListener("click", function (e) {
    const reviewPopup = document.querySelector(".review-popup")
    popupReviewOpen (reviewPopup)
})

const reviewPopupCloseIcon = document.querySelector(".review-popup-close")
reviewPopupCloseIcon.addEventListener("click", function(e) {
    popupReviewClose(e.target.closest(".review-popup"))
})

function popupReviewOpen (openPopup) {
    if (openPopup) {
        const popupReviewActive = document.querySelector(".review-popup.open")
        if (popupReviewActive) {
            popupReviewClose(popupReviewActive)
        }
    }
    openPopup.classList.add("open")
    openPopup.addEventListener("click", function(e) {
        if (!e.target.closest(".review-popup-content")) {
            popupReviewClose(e.target.closest(".review-popup"))
        }
    })
}
function popupReviewClose (popupReviewActive) {
    popupReviewActive.classList.remove("open")
}








function select () {
    let selectHeader = document.querySelectorAll(".select-header")
    let selectItem = document.querySelectorAll(".select-item")

    selectHeader.forEach(item => {
        item.addEventListener("click", selectToggle)
    })
    selectItem.forEach(item => {
        item.addEventListener("click", selectChoose)
    })
}

function selectToggle() {
    this.parentElement.classList.toggle("active-select")
}

function selectChoose() {
    let text = this.innerText,
        select = this.closest(".select"),
        currentText = select.querySelector(".select-current")
    currentText.innerText = text
    select.classList.remove("active-select")
}

select()

let btn_prev = document.querySelector(".buttons-to-slider .prev")
let btn_next = document.querySelector(".buttons-to-slider .next")

let sliderImages = document.querySelectorAll(".barbers-school-photos img")
let i = 0

btn_prev.onclick = function() {
    sliderImages[i].className = ''
    i--
    if(i < 0) {
        i = sliderImages.length - 1
    }
    sliderImages[i].className = "showed"
}
btn_next.onclick = function() {
    sliderImages[i].className = ''
    i++
    if(i >= sliderImages.length) {
        i = 0
    }
    sliderImages[i].className = "showed"
}


// Slider reviews

let position = 0
let slidesToShow = 3
let slidesToScroll = 1
let container = document.querySelector(".slider-container")
const track = document.querySelector(".slider-track")
let items = document.querySelectorAll(".slider-item")
const btnPrev = document.querySelector(".btn-prev")
const btnNext = document.querySelector(".btn-next")
let itemsCount = items.length
let itemWidth = container.clientWidth / slidesToShow 
let movePosition = slidesToScroll * itemWidth

if (container.clientWidth >= 700 && container.clientWidth < 1050) {
    slidesToShow = 2
    itemWidth = container.clientWidth / slidesToShow
    movePosition = slidesToScroll * itemWidth
} 
if (container.clientWidth < 700) {
    slidesToShow = 1
    itemWidth = container.clientWidth / slidesToShow
    movePosition = slidesToScroll * itemWidth
}

let checkBtns = () => {
    btnPrev.style.display = position === 0 ? 'none' : 'inline'
    btnNext.style.display = position <= -(itemsCount - slidesToShow) * itemWidth ? 'none' : 'inline'
}

function setReviewWidth(){
    items = document.querySelectorAll(".slider-item")
    itemsCount = items.length
    checkBtns()

    items.forEach ((item) => {
        item.style.minWidth = `${itemWidth - 30}px` 
    })
}

setReviewWidth();

btnNext.addEventListener("click", () => {
    position -= movePosition

    setPosition()
    checkBtns()
})   

btnPrev.addEventListener("click", () => {
    position += movePosition

    setPosition()
    checkBtns()
})  

const setPosition = () => {
    track.style.transform = `translateX(${position}px)`
}
checkBtns()


//Collect form data
let formName
let formPhone
let formBarberId
let formDay
let formTime
let formReminder
let formComment

let inputName = document.getElementsByName('client-name')[0]
let inputPhone = document.getElementsByName('client-phone')[0]
let selectBarber = document.getElementsByClassName('select-barber')[0]
let selectDay = document.getElementsByClassName('select-date')[0]
let selectTime = document.getElementsByClassName('select-time')[0]
let selectReminder = document.getElementsByClassName('select-reminder')[0]

//Hide fields
selectDay.style.display = 'none'
selectTime.style.display = 'none'
selectReminder.style.display = 'none'

function setName(name){
    formName = name
}

function setPhone(phone){
    formPhone = phone
}

function setComment(comment){
    formComment = comment
}

function setBarber(barberId){
    formBarberId = barberId

    let selectBody = document.querySelectorAll('.select-date')[0].childNodes[3]

    //First remove all days
    while (selectBody.firstChild) {
        selectBody.removeChild(selectBody.lastChild);
    }

    //Clear selected date
    let sDate = document.querySelectorAll('.select-date')[0].childNodes[1].childNodes[3].childNodes[0]
    if (sDate)
        sDate.textContent = ''

    //Get list of days from server
    axios.get('/schedule?barberId='+formBarberId).then(res => {
        res.data.forEach(sch => {
            //Add day only today and later
            if(sch.day >= CURRENT_DAY){
                let hasFreeTime = false
                for(let i = 3; i<Object.values(sch).length; i++) {
                    if(Object.values(sch)[i] === 1){
                        hasFreeTime = true
                        break
                    }
                }

                //Add day only if master has a free time
                if(hasFreeTime) {
                    //Add new day to list
                    let dayElement = document.createElement("div")
                    dayElement.classList.add('select-item')
                    dayElement.innerText = sch.day
                    selectBody.appendChild(dayElement)

                    dayElement.addEventListener("click", function () {
                        let text = this.innerText,
                            select = this.closest(".select"),
                            currentText = select.querySelector(".select-current")
                        currentText.innerText = text
                        select.classList.remove("active-select")

                        //Remove selected time
                        let selectedTime = document.querySelectorAll('.select-time')[0].childNodes[1].childNodes[3].childNodes[0]
                        if (selectedTime)
                            selectedTime.textContent = ''

                        formDay = sch.day
                        initTime(sch)
                    })
                }
            }
        })
    })

    //Update select actions two times, fix it
    select()
    select()

    selectDay.style.display = 'block'
}

function initTime(date){
    let selectBody = document.querySelectorAll('.select-time')[0].childNodes[3]

    //First remove all times
    while (selectBody.firstChild) {
        selectBody.removeChild(selectBody.lastChild);
    }

    for(let i = 3; i<Object.values(date).length; i++) {
        if(Object.values(date)[i] === 1)
            addTime(selectBody, Object.keys(date)[i].replace('h', '') + ':00')
    }

    //Update select actions two times, fix it
    select()
    select()

    selectTime.style.display = 'block'
    selectReminder.style.display = 'block'
}

function addTime(element, time){
    let timeElement = document.createElement("div")
    timeElement.classList.add('select-item')
    timeElement.innerText = time

    timeElement.addEventListener("click", function () {
        let text = this.innerText,
            select = this.closest(".select"),
            currentText = select.querySelector(".select-current")
        currentText.innerText = text
        select.classList.remove("active-select")

        formTime = time
    })

    element.appendChild(timeElement)
}

function submitForm() {
    if(selectReminder.childNodes[1].childNodes[3].textContent)
        formReminder = selectReminder.childNodes[1].childNodes[3].textContent

    if(
        formName &&
        formPhone &&
        formBarberId &&
        formDay &&
        formTime
    ) {
        axios.post('/order', {
            barber: {id: formBarberId},
            name: formName,
            phone: formPhone,
            day: formDay,
            time: formTime,
            reminder: formReminder,
            comment: formComment,
        }).then(res => {
            console.log(res)
        }).finally(() => {
            popupRecordingClose(popupCloseIcon[0].closest(".record-button-popup"))
        })
    }

    if(!formName) inputName.classList.add('required')
    if(!formPhone) inputPhone.classList.add('required')
    if(!formBarberId) selectBarber.classList.add('required')
    if(!formDay) selectDay.classList.add('required')
    if(!formTime) selectTime.classList.add('required')
}