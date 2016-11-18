/**
 * Created by Administrator on 2016/11/7.
 */
var zTreeObj;
// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
var setting = {
    async: {
        enable: true,
        url: "chapter/chapterTree",
        // autoParam: ["id","pId=parentId","name=title"]
    },
    data: {
        key: {
          name: "title",
        },
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: ""
        }
    },
    view: {
        showLine: false,
        showIcon: false,
        expandSpeed: 1,
    },
    callback: {
        onRightClick: OnRightClick
    }
};

function OnRightClick(event, treeId, treeNode) {
    if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
        $.fn.zTree.cancelSelectedNode();
        showRMenu("root", event.clientX, event.clientY);
    } else if (treeNode && !treeNode.noR) {
        $.fn.zTree.selectNode(treeNode);
        showRMenu("node", event.clientX, event.clientY);
    }
}

function showRMenu(type, x, y) {
    $("#rMenu ul").show();
    if (type=="root") {
        $("#m_del").hide();
        $("#m_check").hide();
        $("#m_unCheck").hide();
    } else {
        $("#m_del").show();
        $("#m_check").show();
        $("#m_unCheck").show();
    }
    rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

    $("body").bind("mousedown", onBodyMouseDown);
}

function onBodyMouseDown(event){
    if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
        rMenu.css({"visibility" : "hidden"});
    }
}
$(document).ready(function () {
        $.ajax({
            url: 'chapter/chapterTree',
            datatype: 'json',
            success : function (rslt) {
                console.log(rslt);
            }
        }),
        zTreeObj = $.fn.zTree.init($("#chapter-tree"), setting);
}

)