
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gayan Jayakody
 */
public class Round_Robin extends Thread{
    static ArrayList<String> processName;
    static ArrayList<Integer> burstTime;
    static ArrayList<Integer> arrivalTime;
    static ArrayList<Integer> timeArray=new ArrayList<Integer>();
    static String sequence="";
    static String currentProcess;
    
    public static void process(ArrayList<String> prsName,ArrayList<Integer> avlTime,ArrayList<Integer> bstTime,int qnt) throws InterruptedException{
        processName=prsName;
        burstTime=bstTime;
        arrivalTime=avlTime;
        int time=0;
        
        
        while(true){
            boolean set=true;
            
            for(int j:bstTime){
                if(j!=0){
                    set=false;
                }
            }
            for(int i=0;i<prsName.size();i++){
                //System.out.println(i);
                if (bstTime.get(i)>=qnt && bstTime.get(i)!=0 && avlTime.get(i)<=time){
                    currentProcess=prsName.get(i);
                    sequence+=prsName.get(i);
                    timeArray.add(qnt);
                    //System.out.println(prsName.get(i));
                    bstTime.set(i, bstTime.get(i)-qnt);
                    time+=qnt;
                    set=false;
                    Thread.sleep(qnt*1000);
                    
                }
                else if(bstTime.get(i)<qnt && bstTime.get(i)!=0 && avlTime.get(i)<=time){
                    currentProcess=prsName.get(i);
                    sequence+=prsName.get(i);
                    timeArray.add(bstTime.get(i));
                    //System.out.println(prsName.get(i));
                    time+=bstTime.get(i);                   
                    set=false;
                    Thread.sleep(bstTime.get(i)*1000);
                    bstTime.set(i,0);
                   
                }
                else{
                    time+=1;
                    Thread.sleep(1000);
                    currentProcess="No Process";
                    
                }
                
            }
            if(set==true){
                break;
            }
            
            
            
            
        }
        //System.out.println(sequence);
        //System.out.println(time);
        
    }
    
    
    
}
