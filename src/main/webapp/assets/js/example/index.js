/**
 * Created by Administrator on 2016/11/3.
 */
$(document).ready(
    $.ajax({
        url: 'example/exampleLearnList',
        datatype: 'json',
        success : function (rslt) {
            console.log(rslt);
        }
    }),
    $('#example-table').bootstrapTable({
        columns: [
            {
                field: 'id',
                title: 'Chapter Id'
            },
            {
                field: 'title',
                title: 'Example Id'
            },
            {
                field: 'price',
                title: 'Example Title'
            },
            {
                field: 'date',
                title: 'Create Time'
            }

        ],
        url: 'example/exampleLearnList',
    }),
    $('#example-learn-add').on('click',function () {
        $('#add-modal').modal('show');
    }),
    $('#modal-submit').on('click',function () {
       $.ajax({
           url: 'example/exampleLearnAdd',
           datatype: 'json',
           data: {
               chapter: $('#chapter').val(),
               example: $('#example').val()
           },
           success : function (rslt) {
               console.log(rslt);
               if(rslt.success == 'true'){
                   $('#add-modal').modal('hide');
                   $('#example-table').bootstrapTable('refresh');
               }
           }
       });
    }),
    $('#chapter-lbl').on('click', function () {
        $('#chapter-modal').modal('show');
    }),
    $('#chapter').focus(function () {
        $('body').append("<div id='tree'></div>");

    })
);