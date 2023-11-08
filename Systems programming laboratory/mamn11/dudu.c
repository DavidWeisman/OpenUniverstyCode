

#include <stdio.h>

int main(){
	double dollar_size, dolar_value, shcels_valu, sum_dolars = 0, sum_shcels = 0;
	
	scanf("%lf", &dollar_size);
	
	printf("$\tIS\n");
	while (scanf("%lf", &dolar_value) != EOF) {
		shcels_valu = dolar_value * dollar_size;
		sum_dolars += dolar_value;
		sum_shcels += shcels_valu;
		printf("%.2f\t%.2f\n", dolar_value, shcels_valu);
	}
	printf("%.2f\t%.2f\n", sum_dolars, sum_shcels);	
	
	return 0;
}
