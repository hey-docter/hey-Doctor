const $checkboxs = $(".checkbox-wrap input[type='checkbox']");
const $checkAll = $("input[name='checkAll']");
const $checks = $("input[name='check']");
const $optionsAll = $(".options-title input[name='check']");
const $options = $(".options-list input[name='check']");

$checkAll.on("change", function(){
    let isChecked = $(this).prop("checked");
    isChecked ? checkedAll() : notCheckedAll();
    $checks.prop("checked", isChecked);
    $checks.trigger("change");
});

$checks.on("change", function(){
    let isChecked = $(this).prop("checked");
    let $img = $(this).next().find("img");
    isChecked ? checked($img) : notChecked($img);
});

$optionsAll.on("change", function(){
    $options.prop("checked", $(".options-title input[type='checkbox']").prop("checked"));
    $(".options-list .checkbox-wrap img").attr("src", "/image/icon/" + ($(this).prop("checked") ? "checked.png" : "check.png"));
});

$options.on("change", function(){
    $(".options-title input[type='checkbox']").prop("checked", $options.filter(":checked").length);
    $(".options-title .checkbox-wrap img").attr("src", "/image/icon/" + ($(".options-title input[type='checkbox']").prop("checked") ? "checked.png" : "check.png"));
});

$checkboxs.on("change", function(){
    if($checkboxs.length == $checkboxs.filter(":checked").length){
        $checkAll.prop("checked", true);
        checkedAll();
        return;
    }
    $checkAll.prop("checked", false);
    notCheckedAll();
});

function checkedAll(){
    $("#check-all-wrap span.checkbox").css("border-color", "#2a7de1");
    $("#check-all-wrap span.checkbox").css("background-color", "#2a7de1");
}

function notCheckedAll(){
    $("#check-all-wrap span.checkbox").css("border-color", "");
    $("#check-all-wrap span.checkbox").css("background-color", "");
}

function checked($img){
    $img.attr("src", "/image/icon/checked.png");
    checkAvaliable();
}

function notChecked($img){
    $img.attr("src", "/image/icon/check.png");
    checkAvaliable();
}

function checkAvaliable(){
    if($("#enable").prop("checked")){
        $("li.options").removeClass("disable");
        return;
    }
    $("li.options").addClass("disable");
    $(".options input[type='checkbox']").prop("checked", false);
    $(".options input[type='checkbox']").next().find("img").attr("src", "/image/icon/check.png");
}