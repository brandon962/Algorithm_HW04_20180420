
public class ElementMinimal4105056004 extends ElementMinimal
{
	public static void main(String[] args)
	{
		double A[] = {1,6,4,8,5.3,21,10,3,5,7.2,7.21};
		ElementMinimal4105056004 test = new ElementMinimal4105056004();
		//test.merge_sort(A);
		System.out.println(test.Ele_Min(A));
	}

	public double Ele_Min(double[] A) 
	{
		int len = A.length;
		double []ans = new double[len];
		int piece,start;
		
		for(piece = 1; piece <len; piece *= 2)
		{
			for(start = 0; start < len; start += 2*piece)
			{
				int l = start;
				int m = (start + piece) < len ? (start + piece) : len;
				int h = (start + 2 * piece) < len ? (start + 2 * piece) : len;
				int s1 = l, e1 = m, s2 = m, e2 = h;
				while(s1 < e1 && s2 < e2 && s2 < len)
				{
					ans[l++] = A[s1] < A[s2] ? A[s1++] : A[s2++];
					//System.out.println(ans[l-1]);
				}
				while(s1 < e1)
				{
					ans[l++] = A[s1++];
					//System.out.println(ans[l-1]);
				}
				while(s2 < e2)
				{
					ans[l++] = A[s2++];
					//System.out.println(ans[l-1]);
				}
			}
			double []tmp = A;
			A = ans;
			ans = tmp;
		}
		ans = A;
		double min = (ans[0] - ans[1]) > 0 ? (ans[0] - ans[1]) : -(ans[0] - ans[1]);
		double temp;
		for(int i  = 1 ; i < ans.length; i++) 
		{
			temp = (ans[i-1] - ans[i]) > 0 ? (ans[i-1] - ans[i]) : -(ans[i-1] - ans[i]);
			if(temp < min)
				min = temp;
		}
		
		return min;
	}
}
