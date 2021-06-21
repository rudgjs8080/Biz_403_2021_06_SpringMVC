document.addEventListener("DOMContentLoaded", ()=>{
    document.querySelector("table.main_table")
    .addEventListener("click", (e)=>{

        let tagName = e.target.tagName;
        let tr = e.target.closet("TR").dataset;
        if(tagName == "TD"){
            alert("학생 목록을 클릭해주세요")
        } else if {
            let st_num = tr.num;
            location.href = urlPath + "/score_list?st_num" + st_num;    
           
        }
            
        
    })
})