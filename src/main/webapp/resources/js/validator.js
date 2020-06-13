// Wait for the DOM to be ready
$(document).ready(function () {

    let regex = /\`|\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\+|\=|\[|\{|\]|\}|\||\\|\'|\<|\,|\.|\>|\?|\/|\""|\;|\:/;
    let regexCheckJp = /[\u3000-\u303f\u3040-\u309f\u30a0-\u30ff\uff00-\uff9f\u4e00-\u9faf\u3400-\u4dbf]/;

    let OP = Array.from($('input[data ="OP"]'));
    let shipping_depot_code = Array.from($('input[data ="shippingDepot"]'));
    let shipping_depot_name = Array.from($('input[data ="shippingDepotName"]'));
    let manufacturer_part_number = Array.from($('input[data ="manufactureCode"]'));
    let car_type = Array.from($('input[data ="carType"]'));
    let tr = Array.from($('tr'));
    let reference = Array.from($('button[name ="reference"]'));

    //if line >= 0, set background color <tr> tag in n line
    if (line >= 0) {
        tr[++line].style.backgroundColor = "#f07e75";
    }

    $("#u").click(function () {
    	//reset background color all row
        $('tr').css('background-color', 'inherit');
        
        //reset all message
        $("#error").text("");
        $("#success").text("");
        
        for (let i = 0; i < OP.length; i++) {
            if (OP[i].value.toUpperCase() == '') {

            }
            else if ((OP[i].value.toUpperCase() != 'C') && (OP[i].value.toUpperCase() != 'D')) {
                console.log("'####'")
                $("#error").text((i + 1) + "正しいＯＰを入力してください。");
                OP[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                OP[i].focus();
                return false;
            }


            let isnt_shipping_depot_code = regex.test(shipping_depot_code[i].value);
            if (isnt_shipping_depot_code) {
                $("#error").text("特殊文字を許可しない");
                shipping_depot_code[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                shipping_depot_code[i].focus();
                return false;
            }

            if (shipping_depot_code[i].value == "") {
                $("#error").text((i + 1) + "行目の出荷デポを入力してください。");
                shipping_depot_code[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                shipping_depot_code[i].focus();
                return false;
            }

            let isnt_manufacturer_part_number = regex.test(manufacturer_part_number[i].value);
            if (isnt_manufacturer_part_number) {
                $("#error").text("特殊文字を許可しない");
                manufacturer_part_number[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                manufacturer_part_number[i].focus();
                return false;
            }

            if (manufacturer_part_number[i].value == "") {
                $("#error").text((i + 1) + "メーカー品番をご記入ください。");
                manufacturer_part_number[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                manufacturer_part_number[i].focus();
                return false;
            }

            let isnt_car_type = regex.test(car_type[i].value);
            if (isnt_car_type) {
                $("#error").text("特殊文字を許可しない");
                car_type[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                car_type[i].focus();
                return false;
            }

            if (car_type[i].value == "") {
                $("#error").text((i + 1) + "車種をご記入ください。");
                car_type[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                car_type[i].focus();
                return false;
            }

            if (regexCheckJp.test(shipping_depot_code[i].value)) {
                if (shipping_depot_code[i].value.length * 2 > shipping_depot_code[i].attr('maxLength')) {
                    $("#error").text((i + 1) + "行目の出荷デポは半角文字数を入力してください。");
                    shipping_depot_code[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                    shipping_depot_code[i].focus();
                    return false;
                }
            }

            if (regexCheckJp.test(manufacturer_part_number[i].value)) {
                if (manufacturer_part_number[i].value.length * 2 > manufacturer_part_number[i].attr('maxLength')) {
                    $("#error").text((i + 1) + "行目のメーカ品番は半角文字数を入力してください。");
                    manufacturer_part_number[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                    manufacturer_part_number[i].focus();
                    return false;
                }
            }

            if (regexCheckJp.test(car_type[i].value)) {
                if (car_type[i].val().length * 2 > car_type[i].attr('maxLength')) {
                    $("#error").text((i + 1) + "行目の車種は半角文字数を入力してください。");
                    car_type[i].parentElement.parentElement.style.backgroundColor = "#f07e75";
                    car_type[i].focus();
                    return false;
                }
            }
            
            if (regexCheckJp.test(shipping_depot_code[i].value)) {
            	console.log("japan")
            	return false;
            }

        };

    });

    for (let i = 0; i < reference.length; i++) {
        reference[i].addEventListener('click', function () {
            $.ajax({
                url: context + '/loadshippingdepot',
                dataType: 'text',
                type: 'post',
                data: { shippingDepotCode: shipping_depot_code[i].value },
                success: function (result) {
                	tr[i].style.backgroundColor = "transparent";
                    $("#error").text("");
                    $("#success").text("");
                    $("#shippingDepotName").val(result);
                    if (result == "") {
                        $("#error").text((i+1)+"該当するデータが存在しません。");
                        tr[++i].style.backgroundColor = "#f07e75";
                        --i;
                    } else {
                        shipping_depot_name[i].value = result;
                    }

                },
                error: function () {
                    $("#error").text("データベース接続エラー!");
                    tr[++i].style.backgroundColor = "#f07e75";
                    --i;
                }
            });
        });
    }

});

