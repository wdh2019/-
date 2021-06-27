#include <iostream>
#include <time.h>
#include <fstream>
#include <omp.h>

using namespace std;

int fn(int n){
    if(n==0) return 0;
    if(n==1) return 1;

    return fn(n-1)+fn(n-2);
}

void asyncRead(char* path){
    clock_t start,end;
        ifstream in;
        int count = 0;

        cout << "Start reading" << endl;
        start = clock();
        in.open(path);
        if(!in){
            cerr << "打开文件出错" << endl;
            exit(1);
        }

        char ch;
        while(!in.eof()){
            in.read(&ch,1);
            //cout << ch;
            count++;
        }
        end = clock();
        cout << "End reading, words read: " << count << " and it takes " << (double)(end-start) << " ms!" << endl;
}

void compute(){
        clock_t start,end;
        long result;

        cout << "Start computing" << endl;
        start = clock();
        result = fn(44);
        end = clock();
        cout << "End computing, the result is " << result << " and it takes " << (double)(end - start) << " ms!" << endl;
}

int main(int argc, char* argv[])
{
        //设置一个子线程，异步执行读操作
        omp_set_num_threads(1);
        #pragma omp parallel
    {

        asyncRead(argv[1]);

        #pragma omp master
    {
        //主线程计算斐波那契数列
        compute();

    }

    }

    return 0;
    
}

