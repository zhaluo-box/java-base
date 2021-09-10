package com.example.learn.pattern.proxyModel.sgg.staticproxy;

//???????,???????
public class TeacherDaoProxy implements ITeacherDao{

	private ITeacherDao target; // ?????????????????


	//??????
	public TeacherDaoProxy(ITeacherDao target) {
		this.target = target;
	}



	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("???????  ????Щ?????????????? ");//????
		target.teach();
		System.out.println("????????????");//????
	}

}
