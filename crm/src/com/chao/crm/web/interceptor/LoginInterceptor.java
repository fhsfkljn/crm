package com.chao.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�session�������Ƿ����û���Ϣ������з��У����û�����ء�
		Object object = ActionContext.getContext().getSession().get("loginStaff");
		if(object==null){
			/**�Ѻ���Ϣ start*/
			// 1 ��õ�ǰ����action
			Object action = invocation.getAction();
			// 2 �ж�����ʱ�Ƿ���ActionSupport
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("", "���¼");
			}
			/**�Ѻ���Ϣ end*/
			
			// û�е�¼����Ҫ��¼
			return "login";
		}
		return invocation.invoke();
	}

}
