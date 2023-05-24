
$(document).ready(function () {
    let text = "";
    doctors.forEach(doctor => {

        text += `
            
                                            <div class="swiper-container swiper swiper-container-initialized swiper-container-horizontal">
                                                <div class="swiper-wrapper second-banner">
                                                    <!-- each slide 한 페이지 -->
                                                    <div class="swiper-slide swiper-slide-active"
                                                         style="width: 259px; margin-right: 24px;">
                                                        <div class="pt-landing-card mb-0 index">
                                                            <article class="c-application c-edu-card"
                                                                     style="--card-width: 100%; --image-height: 300px; --background-color: transparent; --title-height: 50px; --border-radius: 10px;">
                                                                <div class="c-edu-card--image-container">
                                                                    <div class="c-edu-card--chip-container">
                                                                        <div>
                                                                            <span class="c-application c-chip fill  info medium">${doctor.doctorType}
                                                                                <!---->
                                                                            </span>
                                                                        </div>
                                                                    </div>
                                                                    <img src="/image/main-page/ex-img.png"
                                                                         alt="" loading="lazy"
                                                                         class="c-edu-card--image">
                                                                </div>
                                                                <div class="c-edu-card--info-container">
                                                                    <div class="c-edu-card--subtitle">
                                                                        <div class="c-application c-typography c-caption1"
                                                                             style="color: rgb(60, 65, 68); font-weight: 400;">
                                                                            유통∙물류
                                                                        </div>
                                                                        <div class="c-application c-typography mx-4 c-caption1"
                                                                             style="color: rgb(207, 212, 215);"> ∙
                                                                        </div>
                                                                        <div class="c-application c-typography c-caption1"
                                                                             style="color: rgb(238, 126, 65);"> 2차 앵콜
                                                                        </div>
                                                                    </div>
                                                                    <div class="c-edu-card--title mt-4">
                                                                        <div class="c-application c-typography c-body1"
                                                                             style="color: rgb(4, 5, 5); font-weight: 500;">
                                                                            글로벌 빅4 컨설팅펌 컨설턴트와 함께하는 SCM(ERP) 실무 역량
                                                                            높이기
                                                                        </div>
                                                                    </div>
                                                                    <div class="c-edu-card--caption mt-8"><span
                                                                            class="c-application c-typography c-caption1"
                                                                            style="color: rgb(173, 179, 184);"> 5주
                                                                                과정 </span>
                                                                        <hr class="c-application c-divider mx-8 line vertical"
                                                                            style="border-color: rgb(234, 236, 238);">
                                                                        <span
                                                                                class="c-application c-typography c-caption1"
                                                                                style="color: rgb(173, 179, 184);"> 5월
                                                                                21일 시작 </span>
                                                                    </div>
                                                                </div>
                                                            </article>
                                                        </div>
                                                    </div>
                                                </div>
                                                <span class="swiper-notification" aria-live="assertive"
                                                      aria-atomic="true">
                                                    </span>
                                            </div>
                                            <svg width="24" height="24" viewBox="0 0 24 24" fill="black"
                                                 xmlns="http://www.w3.org/2000/svg"
                                                 id="swiper-button-prev-outside-2868"
                                                 class="swiper-button swiper-button-outside swiper-button-prev-outside second-prev c-application c-icon outside dark swiper-button-disabled"
                                                 style="fill: rgb(32, 35, 37); transform: rotate(-90deg);"
                                                 tabIndex="-1" role="button">
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                      d="M11.2929 7.29289C11.6834 6.90237 12.3166 6.90237 12.7071 7.29289L19.2071 13.7929C19.5976 14.1834 19.5976 14.8166 19.2071 15.2071C18.8166 15.5976 18.1834 15.5976 17.7929 15.2071L12 9.41421L6.20711 15.2071C5.81658 15.5976 5.18342 15.5976 4.79289 15.2071C4.40237 14.8166 4.40237 14.1834 4.79289 13.7929L11.2929 7.29289Z">
                                                </path>
                                            </svg>
                                            <svg width="24" height="24" viewBox="0 0 24 24" fill="black"
                                                 xmlns="http://www.w3.org/2000/svg"
                                                 id="swiper-button-next-outside-366"
                                                 class="swiper-button swiper-button-outside swiper-button-next-outside second-next c-application c-icon outside dark"
                                                 style="fill: rgb(32, 35, 37); transform: rotate(90deg); opacity: 1; transition: none;"
                                                 tabIndex="0" role="button" aria-label="Next slide"
                                                 aria-disabled="false">
                                                <path data-v-bd9f2bcc="" fill-rule="evenodd" clip-rule="evenodd"
                                                      d="M11.2929 7.29289C11.6834 6.90237 12.3166 6.90237 12.7071 7.29289L19.2071 13.7929C19.5976 14.1834 19.5976 14.8166 19.2071 15.2071C18.8166 15.5976 18.1834 15.5976 17.7929 15.2071L12 9.41421L6.20711 15.2071C5.81658 15.5976 5.18342 15.5976 4.79289 15.2071C4.40237 14.8166 4.40237 14.1834 4.79289 13.7929L11.2929 7.29289Z">
                                                </path>
                                            </svg>
                                    
`
  });
    $('#second-banner').html(text);
});