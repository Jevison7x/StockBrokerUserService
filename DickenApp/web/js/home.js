/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
/* global Swal */

$(document).ready(function(){
    //voting
    $('#vote').click(function(){
        var canId = $('#canId').val().trim();
        var votingPin = $('#votingPin').val().trim();

        $.ajax({
            url: 'handle-election',
            method: 'POST',
            dataType: 'JSON',
            data: {canId: canId, votingPin: votingPin
            },
            beforeSend: function(xhr){
                console.log('Submitting form...');
            },
            success: function(data, textStatus, jqXHR){
                if(data.message !== 'success')
                    Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: data.message
                    });
                else{
                    Swal.fire({
                        icon: 'success',
                        title: 'Successfully Casted your Vote!',
                    });
                    setTimeout(function(){
                        window.location.href = 'http://localhost:8080/DickenApp/home';
                    }, 7000);
                }

            },
            complete: function(jqXHR, textStatus){

            },
            error: function(jqXHR, textStatus, errorThrown){
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: "There was an error, please reload this page. " + errorThrown
                });
            }
        });
    });
});


