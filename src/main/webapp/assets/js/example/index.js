/**
 * Created by Administrator on 2016/11/3.
 */
$(document).ready(
    $.ajax({
        url: 'example/exampleLearnList',
        datatype: 'json',
        success: function (rslt) {

        }
    }),
    $('#example-table').bootstrapTable({
        columns: [
            {
                field: 'id',
                title: 'Chapter Id'
            },
            {
                field: 'example.id',
                title: 'Example Id'
            },
            {
                field: 'example.title',
                title: 'Example Title'
            },
            {
                field: 'createTime',
                title: 'Create Time'
            },
            {
                filed: 'operation',

            }

        ],
        url: 'example/exampleLearnList',
        onDblClickRow: function (row) {
            loadDetailModalData(row);
            $('#detail-modal').modal('show');
        }
    }),

    loadDetailModalData = function (row) {
        console.log(row);
        $('#detail-modal .modal-body div:eq(0) label:eq(1)').text(row.id);
        $('#detail-modal .modal-body div:eq(1) label:eq(1)').text(row.chapterId);
        $('#detail-modal .modal-body div:eq(2) label:eq(1)').text(row.example.id);
        $('#detail-modal .modal-body div:eq(3) label:eq(1)').text(row.example.title);
        $('#detail-modal .modal-body div:eq(4) textarea').val(row.example.content);
        $('#detail-modal .modal-body div:eq(5) textarea').val(row.example.translation);
        // $.ajax({
        //     url: 'example/fetchExampleLearnById',
        //     datatype: 'json',
        //     data: {
        //         id: id,
        //     },
        //     success: function (rslt) {
        //         console.log(rslt);
        //         //加载数据
        //     }
        // });
    },

    $('#example-learn-add').on('click', function () {
        $('#add-modal').modal('show');
    }),
    $('#modal-submit').on('click', function () {
        if ($('#chapter-id').val() == '') {
            alert("请选择一个章节");
            return;
        }
        $.ajax({
            url: 'example/exampleLearnAdd',
            datatype: 'json',
            data: {
                chapter: $('#chapter-id').val(),
                example: $('#example').val()
            },
            success: function (rslt) {
                if (rslt.success == 'true') {
                    $('#add-modal').modal('hide');
                    $('#example-table').bootstrapTable('refresh');
                }
            }
        });
    }),

    $('#detail-submit').click(function () {
        $.ajax({
            url: 'example/exampleLearnDetailSubmit',
            datatype: 'json',
            data: {
                id : $('#example-id').text(),
                content: $('#content').val(),
                translation: $('#translation').val()
            },
            success: function (rslt) {
                if (rslt.success == 'true') {
                    $('#detail-modal').modal('hide');
                    $('#example-table').bootstrapTable('refresh');
                }
            }
        });
    }),
    $('#chapter-lbl').on('click', function () {
        $('#chapter-modal').modal('show');
    }),
    $('#chapter').focus(function () {
        if ($('#chapter-tree').html() != '') {
            $('#chapter-tree').show();
            return;
        }
        $.ajax({
            url: 'chapter/chapterTree',
            datatype: 'json',
            success: function (rslt) {
                addTreeToTxtBottom(rslt);
            },
            error: function () {
                console.log('error');
            }
        })
    })
// $('#example-table').click(function () {
//     console.log(123);
//     $('#detail-modal').modal('show');
// }),


// $('#example-table tbody tr').click(function () {
//     console.log(123);
//     $('#detail-modal').modal('show');
// })

)
;

function addTreeToTxtBottom(list) {
    list = $.parseJSON(list);
    var map = {};
    var root = {};
    root.id = 'root';
    root.children = [];
    for (var i = 0; i < list.length; i++) {
        // console.log(list[i]);
        var listId = list[i].id;
        map['id' + listId] = list[i];
    }
    for (var i = 0; i < list.length; i++) {
        var parentId = list[i].parentId;
        if (map['id' + parentId] == undefined) {
            root.children.push(list[i]);
        } else {
            if (map['id' + parentId].children == undefined) {
                map['id' + parentId].children = [];
            }
            map['id' + parentId].children.push(list[i])
        }
    }
    var html = paintTree(root, '');
    $('#chapter-tree').html(html);
    $('#chapter-tree').css({
        "left": $('#chapter').css('left'),
        "width": $('#chapter').width()
    });
    $('#chapter-tree').show();
    nodeEventBind();
}

function nodeEventBind() {
    $('.tree-node').click(function (e) {
        e.stopPropagation();
        $('#chapter').val($(this).find('span:eq(0)').text());
        $('#chapter-id').val($(this).attr('node-id'));
        $('#chapter-tree').hide();
    });
}

function paintTree(node, html) {
    if (node.id != 'root') {
        html += '<li class="tree-node"  node-id="' + node.id + '">';
        html += '<span class="tree-span">' + node.title + '</span>';
        var children = node.children;
        if (children == undefined) {

        } else {
            children = childrenSort(children);
            html += '<ul>';
            for (var i = 0; i < children.length; i++) {
                html = paintTree(children[i], html);
            }
            html += '</ul>';
        }
        html += '</li>'
    } else {
        var children = node.children;
        if (children == undefined) {
            html += '<span>There is no node!</span>';
        } else {
            children = childrenSort(children);
            html += '<ul>';
            for (var i = 0; i < children.length; i++) {
                html = paintTree(children[i], html);
            }
            html += '</ul>'
        }
    }
    return html;
}

function childrenSort(children) {
    return children.sort(function (childA, childB) {
        return childA.order - childB.order;
    })
}