#include <iostream>
#define n 2000000

int main(){
    int a[n+1]={0},count=0;
    unsigned long long sum = 0;
    for(int i=2;i<=n;i++){
        if(a[i]==0){
            for(int j=i;j<=n;j+=i) a[j]=1;
            sum+=i;
            count++;
        }
    }
    std::cout<<"The sum of all primes up to "<<n<<" is "<<sum<<"."<<std::endl
    <<"There are "<<count<<" primes that are smaller than "<<n<<"."<<std::endl;
    return 0;
}
