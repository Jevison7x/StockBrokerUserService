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
//register a student
    $('#signup').submit(function(e){
        e.preventDefault();
        var name = $('#name').val().trim();
        var matNumber = $('#matNumber').val().trim();
        var password = $('#password').val().trim();
        var faculty = $('#faculty').val().trim();
        var departtment = $('#departtment').val().trim();
        var level = $('#level').val().trim();
        /*
         * Use AJAX to submit the information
         */
        $.ajax({
            url: 'create-new-student',
            method: 'POST',
            dataType: 'JSON',
            data: {name: name, matNumber: matNumber, password: password,
                faculty: faculty, departtment: departtment, level: level
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
                        title: 'Account Created Successfully!',
                        text: 'Your account has been created successfully!\nYou can now login to continue.'
                    });
                    setTimeout(function(){
                        window.location.href = 'http://localhost:8080/DickenApp/login.jsp';
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
    //register a elecoAdmin
    $('#signupCand').submit(function(e){
        e.preventDefault();
        var name = $('#name').val();
        var password = $('#password').val();
        /*
         * Use AJAX to submit the information
         */
        $.ajax({
            url: 'create-new-admin',
            method: 'POST',
            dataType: 'JSON',
            data: {name: name, password: password
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
                        title: 'Account Created Successfully!',
                        text: 'Your account has been created successfully!\nYou can now login to continue.'
                    });
                    setTimeout(function(){
                        window.location.href = 'http://localhost:8080/DickenApp/login.jsp';
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
    //register a candidate
    $('#signupCan').submit(function(e){
        e.preventDefault();
        var name = $('#name').val().trim();
        var password = $('#password').val();
        var position = $('#position').val().trim();
        var authPin = $('#authPin').val().trim();
        /*
         * Use AJAX to submit the information
         */
        $.ajax({
            url: 'create-new-candidate',
            method: 'POST',
            dataType: 'JSON',
            data: {name: name, password: password, position: position, authPin: authPin
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
                        title: 'Account Created Successfully!',
                        text: 'Your account has been created successfully!\nYou can now login to continue.'
                    });
                    setTimeout(function(){
                        window.location.href = 'http://localhost:8080/DickenApp/login.jsp';
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
    //load pin table
    $.ajax({
        url: "pin-datatable",
        type: "GET",
        dataType: "json",
        success: function(data){
            // Handle the data returned from the servlet with datatables.net
            $("#itemTable").DataTable({
                data: data,
                columns: [
                    {data: "sn"},
                    {data: "pinId"},
                    {data: "status"},
                    {data: "dateIssued"},
                    {data: "dateUsed"},
                    {data: "usedBy"}
                ]
            });
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log("Error: " + textStatus + " - " + errorThrown);
        }
    });
    //load candidate table
    $.ajax({
        url: "manageCandidate",
        type: "GET",
        dataType: "json",
        success: function(data){
            // Handle the data returned from the servlet with datatables.net
            $("#manageCandidate").DataTable({
                data: data,
                columns: [
                    {data: "canId"},
                    {data: "name"},
                    {data: "position"},
                    {
                        "data": null,
                        "render": function(data, type, row, meta){
                            return '<button class="disqualify-btn" data-id="' + row.id + '">Disqualify</button>';
                        }
                    }
                ]
            });
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log("Error: " + textStatus + " - " + errorThrown);
        }
    });
});



