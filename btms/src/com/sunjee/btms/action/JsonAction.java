package com.sunjee.btms.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.btms.bean.Member;
import com.sunjee.btms.common.Sex;

@Controller("jsonAction")
@Scope("prototype")
public class JsonAction extends BaseAction {

	private static final long serialVersionUID = -3395691357244946291L;
	
	Map<String, Object> dataGrid;
	private String name[];

	public Map<String, Object> getDataGrid() {
		return dataGrid;
	}


	public void setDataGrid(Map<String, Object> dataGrid) {
		this.dataGrid = dataGrid;
	}


	public String[] getName() {
		return name;
	}


	public void setName(String[] name) {
		this.name = name;
	}


	public String getList() throws Exception{  
/*        List<Member> list = new ArrayList<Member>();  
        int count = this.getRows();
        for(int i=0;i<count;i++){  
        	Sex sex = Sex.values()[0];
        	if((i % 4) == 0)
        		sex = Sex.values()[1];
        	Member mem = new Member("1000" + i, "会员名称" + i, sex, "啊萨克族", "云南");
        	list.add(mem);
        }  
        
        Map<String, Object> data = new HashMap<>();
        data.put("total", count * 5);
        data.put("rows", list);
        this.dataGrid = data;
        if(name != null){
        	for(String n : name){
        		System.out.println("name == " + n);
        	}
        }
        Thread.sleep(1000 * 3);
*/        return SUCCESS;  
    }  


	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
