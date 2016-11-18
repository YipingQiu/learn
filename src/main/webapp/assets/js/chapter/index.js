// $(document).ready(function () {
//
// })

$(function () {
    console.log(1);
    $(document).ready(function () {
        console.log(1);
        $.ajax({
            url: 'chapter/chapterTree',
            datatype: 'json',
            success : function (rslt) {
                console.log(rslt);
                loadTree(rslt);
            }
        })
    })

    function eventBind() {
        $('.tree-span').click(function () {
            if($(this).next().is(':hidden')){
                $(this).next().show();
            }else {
                $(this).next().hide();
            }
        })
    }

    function loadTree(list) {
        list = $.parseJSON(list);
        var map = {}
        var root ={}
        root.id = 'root';
        root.children = [];
        for(var i = 0; i < list.length; i++){
            console.log(list[i]);
            var listId = list[i].id;
            map['id' + listId] = list[i];
        }
        for(var i = 0; i < list.length; i++){
            var parentId = list[i].parentId;
            if(map['id' + parentId] == undefined){
                root.children.push(list[i]);
            }else{
                if(map['id' + parentId].children == undefined){
                    map['id' + parentId].children = [];
                }
                map['id' + parentId].children.push(list[i])
            }
        }
        var html = '';
        html = paintTree(root,'');
        console.log(html);
        $('#chapter-tree').html(html);
        eventBind();
        // console.log(root);
    }

    function paintTree(node, html) {
        if(node.id!='root') {
            html += '<li class="tree-node">';
            html += '<span class="tree-span">' + node.title + '</span>'
            var children = node.children;
            if (children == undefined) {

            } else {
                html += '<ul>';
                for (var i = 0; i < children.length; i++) {
                    html = paintTree(children[i], html);
                }
                html += '</ul>';
            }
            html += '</li>'
        }else{
            var children = node.children;
            if (children == undefined) {

            } else {
                html += '<ul>'
                for (var i = 0; i < children.length; i++) {
                    html = paintTree(children[i], html);
                }
                html += '</ul>'
            }
        }
        return html;
    }
})