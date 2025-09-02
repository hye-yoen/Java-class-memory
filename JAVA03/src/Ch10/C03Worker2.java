package Ch10;

public class C03Worker2 implements Runnable{
	
	C03GUI gui;
	public C03Worker2(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {
		while(true) {
			
			gui.area2.append("이게 됨?\n"); //이게 진짜 되네.. try문 밖인데...
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}		
		}
		
		
		System.out.println("임시 종료");
		
	}
	
}
