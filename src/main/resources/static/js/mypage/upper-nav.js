const $upperTabs = $('.c-tabs--menu-button');

$upperTabs.children('a').each(function (i, a) {
   $(a).on('click', function () {
      if(!$upperTabs.eq(i).is('.active')) {
         $upperTabs.each((i, div) => $(div).removeClass('active'));
         $upperTabs.eq(i).addClass('active');

         $upperTabs.each((i, a_element) => $(a_element).removeClass('nuxt-link-exact-active').removeClass('nuxt-link-active'));
         $(this).addClass('nuxt-link-exact-active').addClass('nuxt-link-active');
      }
   }); 
});