$(document).ready(function () {

    var nodeOperate = 0;
    var deleteNodes = [];

    var chapter = {
        init: function () {
            this.eventBind();
            this.loadData();
        },
        loadData: function () {
            $.ajax({
                url: 'chapter/chapterTree',
                datatype: 'json',
                success: function (rslt) {
                    chapter.loadTree(rslt);
                },
                error: function () {
                    console.log('error');
                }
            })
        },

        loadTree: function (list) {
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
            var html = chapter.paintTree(root, '');
            $('#chapter-tree').html(html);
            chapter.eventBind();
        },
        eventBind: function () {
            $('.tree-span').click(function () {
                if ($(this).next().is(':hidden')) {
                    $(this).next().show();
                } else {
                    $(this).next().hide();
                }
            });
            $('.tree-node').on('drag',function (e) {
                e.stopPropagation();
            });

            $('.tree-node').on('dragstart',function (e) {
                e.stopPropagation();
                e.dataTransfer = e.originalEvent.dataTransfer;
                e.dataTransfer.setData("Text", $(e.target).attr('node-id'));
            });

            $('.tree-node').on('dragend',function (e) {
                e.stopPropagation();
            });

            $('#chapter-tree, .tree-node').on('dragover',function (e) {
                e.stopPropagation();
                e.preventDefault();
            });

            $('#chapter-tree').on('drop',function (e) {
                e.preventDefault();
                e.dataTransfer = e.originalEvent.dataTransfer;
                var data = e.dataTransfer.getData("Text");
                $(this).find('ul:eq(0)').append($('[node-id='+ data + ']'));
                chapter.loadSaveDiv();
            });

            $('.tree-node').on('drop',function (e) {
                e.stopPropagation();
                e.preventDefault();
                e.dataTransfer = e.originalEvent.dataTransfer;
                var data = e.dataTransfer.getData('Text');
                var move = $('[node-id='+ data + ']');

                var mouseY = e.pageY;
                var nodeTop = $(e.target).offset().top;
                var nodeHeight = $(e.target).height();

                if(mouseY < nodeTop + 5){
                    $(this).before(move);
                }else if(mouseY > nodeTop + nodeHeight - 5){
                    $(this).after(move);
                }else {
                    if($(this).attr('node-id') == data){
                        return;
                    }
                    if($(this).find('ul').html() == undefined){
                        $(this).append('<ul></ul>');
                        $(this).find('ul').append(move);
                    }else{
                        $(this).find('ul:eq(0)').append(move);
                    }
                }
                chapter.loadSaveDiv();
            });


            $('.tree-span').contextmenu(function (event) {
                event.preventDefault();
                if ($(this).next().is(':hidden')) {
                    $(this).next().show();
                }
                var nodeId = $(this).parent().attr('node-id');
                var html = '';
                html += '<div id="tree-menu" node-id="' + nodeId + '">';
                html += '<ul>';
                if($(this).parent().prev().html() != undefined){
                    html += '<li><span><a href="javascript:;" class="node-up">节点上移</a></span></li>';
                }
                html += '<li><span><a href="javascript:;" class="add-child">增加子节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="add-prev">增加前驱节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="add-next">增加后继节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="modify-name">修改名称</a></span></li>';
                html += '<li><span><a href="javascript:;" class="remove-node">删除节点</a></span></li>';
                if($(this).parent().next().html() != undefined){
                    html += '<li><span><a href="javascript:;" class="node-down">节点下移</a></span></li>';
                }
                html += '</ul>';
                html += '</div>';
                $('body').append(html);
                $('#tree-menu').css({
                    position: 'absolute',
                    left: event.pageX + 'px',
                    top: event.pageY + 'px'
                });
                $('#tree-menu li').css({
                    'list-style-type': 'none',
                    'background-color': '#ccc'
                });
                chapter.menuEventBind();
            });
            $(document).mousedown(function (e) {
                var targetClass = $(e.target).attr('class');
                // console.log(targetClass);
                if (targetClass == 'add-child'
                    || targetClass == 'add-prev'
                    || targetClass == 'add-next'
                    || targetClass == 'modify-name'
                    || targetClass == 'remove-node'
                    || targetClass == 'node-up'
                    || targetClass == 'node-down'
                ) {
                    return;
                }
                if ($('#tree-menu').html() != undefined) {
                    $('#tree-menu').remove();
                }
            });
        },
        menuEventBind: function () {

            $('.node-up').click(function () {
                $('#tree-menu').remove();
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                var node = $('.tree-node[node-id=' + nodeId + ']');
                node.after(node.prev());
                chapter.loadSaveDiv();
            });

            $('.node-down').click(function () {
                $('#tree-menu').remove();
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                var node = $('.tree-node[node-id=' + nodeId + ']');
                node.before(node.next());
                chapter.loadSaveDiv();
            });

            $('.remove-node').click(function () {
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                var node = {};
                node.id = nodeId;
                node.children = {};
                node.children = chapter.childrenTraverse(node.children,$('.tree-node[node-id=' + nodeId + ']'));
                deleteNodes.push(node);
                $('#tree-menu').remove();
                var node = $('.tree-node[node-id=' + nodeId + '] ');
                node.remove();
                chapter.loadSaveDiv();
            });

            $('.modify-name').click(function () {
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                var node = $('.tree-node[node-id=' + nodeId + '] ');
                $('#tree-menu').remove();
                var oldName = node.find('span').text();
                node.html('<input type="text" placeholder="请输入一个名称">');
                var txt = $('.tree-node[node-id=' + nodeId + '] input');
                txt.focus();
                txt.blur(function () {
                    var nodeName = txt.val();
                    if (nodeName == '') {
                        nodeName = oldName;
                    }
                    node.html('<span>' + nodeName + '</span>');
                });
                chapter.loadSaveDiv();
            });

            $('.add-child,.add-prev,.add-next').click(function () {
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                $('#tree-menu').remove();
                var node = $('.tree-node[node-id=' + nodeId + '] ');
                var html = '<li class="tree-node" node-id="new' + ++nodeOperate + '"><input type="text" placeholder="请输入一个名称"></li>';
                var operateClass = $(this).attr('class');
                if (operateClass == 'add-child') {
                    if (node.find('ul').html() == undefined) {
                        html = '<ul>' + html + '</ul>';
                        node.append(html)
                    } else {
                        node.find('ul:eq(0)').append(html);
                    }
                } else if (operateClass == 'add-prev') {
                    node.before(html);
                } else if (operateClass == 'add-next') {
                    node.after(html);
                }
                $('.tree-node[node-id=new' + nodeOperate + '] input').focus();
                $('.tree-node[node-id=new' + nodeOperate + '] input').blur(function () {
                    var nodeName = $('.tree-node[node-id=new' + nodeOperate + '] input').val();
                    if (nodeName == '') {
                        nodeName = '新节点' + nodeOperate;
                    }
                    $('.tree-node[node-id=new' + nodeOperate + ']').html('<span>' + nodeName + '</span>');
                });
                chapter.loadSaveDiv();
            });
        },
        loadSaveDiv: function () {
            if($('#save-div').html() == undefined){
                var html = '';
                html += '<div id="save-div">';
                html += '<button id="save-tree">保存</button>';
                html += '<button id="cancle-save">取消</button>';
                html += '</div>';
                $('body').append(html);
                chapter.saveEventBind();
            }
        },
        saveEventBind : function () {
            $('#save-tree').click(function () {
                var tree = {};
                tree.id = 'root';
                tree.children = [];
                tree.children = chapter.childrenTraverse(tree.children, $('#chapter-tree'));
                console.log(tree);
                $.ajax({
                    url: 'chapter/saveTree',
                    type: 'post',
                    data: {
                        deleteNodes : JSON.stringify(deleteNodes),
                        tree : JSON.stringify(tree)
                    },
                    datatype: 'json',
                    success: function () {
                        $('#save-div').remove();
                        chapter.loadData();
                    },
                    error: function () {
                        console.log('error');
                    }
                })
            });
            $('#cancle-save').click(function () {
                $('#save-div').remove();
                chapter.loadData();
            });
        },
        paintTree: function (node, html) {
            if (node.id != 'root') {
                html += '<li class="tree-node" draggable="true" node-id="' + node.id + '">';
                html += '<span class="tree-span">' + node.title + '</span>';
                var children = node.children;
                if (children == undefined) {

                } else {
                    children = chapter.childrenSort(children);
                    html += '<ul>';
                    for (var i = 0; i < children.length; i++) {
                        html = chapter.paintTree(children[i], html);
                    }
                    html += '</ul>';
                }
                html += '</li>'
            } else {
                var children = node.children;
                if (children == undefined) {
                    html += '<span>There is no node!</span>';
                } else {
                    children = chapter.childrenSort(children);
                    html += '<ul>';
                    for (var i = 0; i < children.length; i++) {
                        html = chapter.paintTree(children[i], html);
                    }
                    html += '</ul>'
                }
            }
            return html;
        },
        childrenSort: function (children) {
            return children.sort(function (childA, childB) {
                return childA.order - childB.order;
            })
        },
        childrenTraverse: function (children, _this) {
            children = []
            _this.children().children().each(function (i) {
                children[i] = {};
                children[i].id = $(this).attr('node-id');
                children[i].order = i + 1;
                children[i].title = $(this).children().first().text();
                children[i].children = chapter.childrenTraverse(children[i].children, $(this));
            });
            return children;
        }
    }

    chapter.init();
})
