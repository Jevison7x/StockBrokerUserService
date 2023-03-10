<%--
    Document   : home
    Created on : Feb 25, 2023, 1:06:06 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean scope="session" id="elecoadmin" class="com.dickens.users.ElecoAdmin"/>
<jsp:useBean scope="session" id="candidate" class="com.dickens.users.Candidate"/>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/fragments/dashboard/head-codes.jsp"/>
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/fragments/dashboard/header.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/sidebar.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/home-content.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/footer.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/scripts.jsp"/>
        <script>
            //the chart
            $(document).ready(function(){
                $.get("display-chart", function(data){
                    var chartData = [];
                    for(var key in data){
                        chartData.push({x: key, y: data[key]});
                    }
                    var chart = new ApexCharts(document.querySelector("#reportsChart"), {
                        series: [{
                                data: chartData
                            }],
                        chart: {
                            type: 'bar',
                            height: 350
                        },
                        plotOptions: {
                            bar: {
                                horizontal: false,
                                columnWidth: '55%',
                                endingShape: 'rounded'
                            },
                        },
                        dataLabels: {
                            enabled: false
                        },
                        stroke: {
                            show: true,
                            width: 2,
                            colors: ['transparent']
                        },
                        xaxis: {
                            type: 'category'
                        },
                        yaxis: {
                            title: {
                                text: 'Votes'
                            }
                        },
                        fill: {
                            opacity: 1
                        },
                        tooltip: {
                            y: {
                                formatter: function(val){
                                    return val;
                                }
                            }
                        }
                    });
                    chart.render();
                });
            });
        </script>
    </body>
</html>
