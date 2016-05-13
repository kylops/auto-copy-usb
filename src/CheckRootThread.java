import java.io.File;

/*
 * @Kyle
 * 13/05/2016
 * check if there is a new root apprearing, and trigger the copy
 */
public class CheckRootThread extends Thread{
	private File[] sysRoot = File.listRoots();
	
	public void run(){
	
	 File[] currentRoot = null;
	 
     while (true) {  
        // 当前的系统盘符  
        currentRoot = File.listRoots();
        //check if there is a new root
        if (currentRoot.length > sysRoot.length) {  
            for (int i = currentRoot.length - 1; i >= 0; i--) {  
                boolean isNewRoot = true;  
                for (int j = sysRoot.length - 1; j >= 0; j--) {  
                    // 当两者盘符不同时，触发新盘符文件的拷贝  
                    if (currentRoot[i].equals(sysRoot[j])) {  
                        isNewRoot = false;  
                    }  
                }  
                if (isNewRoot) {  
                    new CopyThread(currentRoot[i]).start();  
                }  
            }  
        }  
        sysRoot = File.listRoots();  
        //每5秒时间检查一次系统盘符  
        try {  
            Thread.sleep(5000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}
}
