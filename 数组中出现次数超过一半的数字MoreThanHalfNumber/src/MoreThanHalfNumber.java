import java.util.Scanner;

/*
 * 文件名称：《剑指Offer：名企面试官精讲典型编程题(纪念版)》面试题29：数组中出现次数超过一半的数字
 * 时间：2016-8-18 21:22
 * 说明：1、数组中有一个数字出现的次数超过数组长度的一半。
 * 
 * */

public class MoreThanHalfNumber {
	
	public static int Partition(int []a,int start,int end){
		int pivotkey=a[start];
		
		while(start<end){
			while((start<end)&&(a[end]>=pivotkey)){
				end--;
			}
			swap(a,start,end);
			while((start<end)&&(a[start]<=pivotkey)){
				start++;
			}
			swap(a,start,end);
//			System.out.println("Partition,start="+start+",end="+end);
		}
//		System.out.println("Partition,start="+start+",end="+end);
		return start;
	}
	
	private static void swap(int[] a,int i,int j) {
		// TODO Auto-generated method stub
		int temp=a[i];
		a[i]=a[j];
		a[j]=(int) temp;
	}
	
	
	public static int MoreThanHalfNum_Solution1(int []a){
		
		if(a==null||a.length<=0){
			return 0;
		}
		int result=0;
		int middle=a.length>>1;
		int start=0;
		int end=a.length-1;
		int i=Partition(a, start, end);
		
//		System.out.println("middle="+middle+",i="+i);
		
		while(i!=middle){
			if(i<middle){
				start=i+1;
//				System.out.println("******");
				i=Partition(a, start, end);
			}else if(i>middle){
				end=i-1;
				i=Partition(a, start, end);
			}
//			System.out.println("##,start="+start+",end="+end+",i="+i);
		}
		
//		System.out.println(a[middle]);
		
		result=a[middle];
		
		if(!checkMoreThanHalf(a, result)){
			result=0;
		}
		return result;
	}
	
	
	public static int MoreThanHalfNum_Solution2(int []a){
		int result=0;
		int times=0;
		int i=0;
		
		if(a==null||a.length<=0){
			return 0;
		}
		result=a[0];
		times=1;
		
		for(i=1;i<a.length;i++){
			if(times==0){
				times=1;
				result=a[i];
			}
			else if(a[i]==result){
				times++;
			}else{
				times--;
			}
		}
		if(!checkMoreThanHalf(a,result)){
			result=0;
		}
		return result;
		
	}

	private static boolean checkMoreThanHalf(int[] a, int result) {
		boolean isMoreThanHalf=false;
		int times=0;
		
		for(int i=0;i<a.length;i++){
			if(a[i]==result){
				times++;
			}
		}
		if(times*2<=a.length){
			isMoreThanHalf=false;
		}else{
			isMoreThanHalf=true;
		}
		return isMoreThanHalf;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Scanner in=new Scanner(System.in);
//		while(in.hasNext()){
//			int n=in.nextInt();
//			int []a=new int[n];
//			for(int i=0;i<n;i++){
//				a[i]=in.nextInt();
//			}
//			System.out.println(MoreThanHalfNum_Solution1(a));
//		}
		int []a=new int[]{1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution1(a));
		
	}
}
