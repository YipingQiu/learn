$(document).ready(function () {

    var nodeOperate = 0;
    var deleteNodes =[];

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
                }
            })
        },

        loadTree: function(list) {
            list = $.parseJSON(list);
            var map = {};
            var root = {};
            root.id = 'root';
            root.children = [];
            for (var i = 0; i < list.length; i++) {
                console.log(list[i]);
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
            console.log(html);
            $('#chapter-tree').html(html);
            chapter.eventBind();
            // console.log(root);
        },
        eventBind: function () {
            $('.tree-span').click(function () {
                if ($(this).next().is(':hidden')) {
                    $(this).next().show();
                } else {
                    $(this).next().hide();
                }
            });
            $('.tree-span').contextmenu(function (event) {
                event.preventDefault();
                if ($(this).next().is(':hidden')) {
                    $(this).next().show();
                }
                var nodeId = $(this).parent().attr('node-id');
                var html = '';
                html += '<div id="tree-menu" node-id="' + nodeId +'">';
                html += '<ul>';
                html += '<li><span><a href="javascript:;" class="add-child">增加子节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="add-prev">增加前驱节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="add-next">增加后继节点</a></span></li>';
                html += '<li><span><a href="javascript:;" class="modify-name">修改名称</a></span></li>';
                html += '<li><span><a href="javascript:;" class="remove-node">删除节点</a></span></li>';
                html += '</ul>';
                html += '</div>';
                $('body').append(html);
                $('#tree-menu').css({
                    position:'absolute',
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
                if(targetClass == 'add-child'
                    || targetClass == 'add-prev'
                    || targetClass == 'add-next'
                    || targetClass == 'modify-name'
                    || targetClass == 'remove-node'
                ){
                    return;
                }
                if ($('#tree-menu').html() != undefined) {
                    $('#tree-menu').remove();
                }
            });
        },
        menuEventBind: function () {

            $('.remove-node').click(function () {
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                deleteNodes.push(nodeId);
                $('#tree-menu').remove();
                var node = $('.tree-node[node-id=' + nodeId + '] ');
                node.remove();
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
                    if(nodeName==''){
                        nodeName = oldName;
                    }
                    node.html('<span>' + nodeName + '</span>');
                });
            });

            $('.add-child,.add-prev,.add-next').click(function () {
                var nodeId = $(this).parent().parent().parent().parent().attr('node-id');
                $('#tree-menu').remove();
                var node = $('.tree-node[node-id=' + nodeId + '] ');
                var html = '<li class="tree-node" node-id="new' + ++nodeOperate + '"><input type="text" placeholder="请输入一个名称"></li>';
                var operateClass = $(this).attr('class');
                if(operateClass == 'add-child'){
                    if(node.find('ul').html() == undefined){
                        html = '<ul>' + html + '</ul>';
                        node.append(html)
                    }else{
                        node.find('ul:eq(0)').append(html);
                    }
                }else if(operateClass == 'add-prev'){
                    node.before(html);
                }else if(operateClass == 'add-next'){
                    node.after(html);
                }

                // console.log($('.tree-node[node-id=new'+ nodeOperate + ']').html());
                $('.tree-node[node-id=new'+ nodeOperate + '] input').focus();
                $('.tree-node[node-id=new'+ nodeOperate + '] input').blur(function () {
                    var nodeName = $('.tree-node[node-id=new'+ nodeOperate + '] input').val();
                    if(nodeName == ''){
                        nodeName = '新节点' + nodeOperate;
                    }
                    $('.tree-node[node-id=new'+ nodeOperate + ']').html('<span>' + nodeName + '</span>');
                });
            });
        },
        paintTree: function (node, html) {
            if (node.id != 'root') {
                html += '<li class="tree-node" node-id="' + node.id +'">';
                html += '<span class="tree-span">' + node.title + '</span>';
                var children = node.children;
                if (children == undefined) {

                } else {
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

                } else {
                    html += '<ul>';
                    for (var i = 0; i < children.length; i++) {
                        html = chapter.paintTree(children[i], html);
                    }
                    html += '</ul>'
                }
            }
            return html;
        }
    }

    chapter.init();
})
