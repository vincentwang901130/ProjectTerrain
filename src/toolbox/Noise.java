package toolbox;
public class Noise {
	
	
	private static int Number_Of_Octaves=20;	
	
	public  static float Noise1(int x, int y)
	{
		x = x % 30;
		y = y % 30;
		int n = x + y *57;
		n = (n << 13) ^ n;
		return (1.0f - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0f);
	}
	

	public  static float SmoothNoise_1(int x, int y)
{
	float corners = (Noise1(x - 1, y - 1) + Noise1(x + 1, y - 1) + Noise1(x - 1, y + 1) + Noise1(x + 1, y + 1)) / 16.0f;
	float sides = (Noise1(x - 1, y) + Noise1(x + 1, y) + Noise1(x, y - 1) + Noise1(x, y + 1)) / 8.0f;
	float center = Noise1(x, y) / 4.0f;
	return corners + sides + center;
}

	public  static float Cosine_Interpolate(float a, float b, float x)
	{
		double ft = x * 3.1415926535;
		double f = (1 - Math.cos(ft)) * 0.5f;
		return  (float)(a*(1 - f) + b*f);
	}


	public  static float InterpolatedNoise_1(float x, float y)
	{

		int integer_X = (int)x;
		float fractional_X = x - integer_X;
		int integer_Y = (int)y;
		float fractional_Y = y - integer_Y;
		float v1 = SmoothNoise_1(integer_X, integer_Y);
		float v2 = SmoothNoise_1(integer_X + 1, integer_Y);
		float v3 = SmoothNoise_1(integer_X, integer_Y + 1);
		float v4 = SmoothNoise_1(integer_X + 1, integer_Y + 1);
		float i1 = Cosine_Interpolate(v1, v2, fractional_X);
		float i2 = Cosine_Interpolate(v3, v4, fractional_X);
		return Cosine_Interpolate(i1, i2, fractional_Y);
	}
	
	
	public static float PerlinNoise_2D(float x, float y, float p)
	{
		float total = 0.0f;
	//	float p = 0.35f;
		int n = Number_Of_Octaves - 1;

		for (int i = 0; i <= n; i++)
		{
			float frequency =(float) Math.pow((float)2, i);
			float amplitude =(float) Math.pow(p, i);
			total = total + InterpolatedNoise_1(x * frequency, y * frequency) * amplitude;
		}

		return total;
	}
	
	
	
	
}
