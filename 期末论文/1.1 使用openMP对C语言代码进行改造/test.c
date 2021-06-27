#include <omp.h>
#include <stdio.h>
 
 int main()
{
    #pragma omp parallel for
    for(int i=0; i<10; i++){
        printf("%d",i);
    }

    return 0;
}
