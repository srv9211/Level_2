#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;
    int* arr = new int[n];
    for(int i = 0 ; i < n; i++){
        cin>>arr[i];
    }
    int data;
    cin>>data;
    
    // write your code here
    
    int lo = 0, hi = n-1;
    
    int f = n;
    while(lo<=hi){
        int mid = lo+(hi-lo)/2;
        
        if(arr[mid]>=data){
            f = mid;
            hi = mid-1;
        }
        else if(arr[mid]<data){
            lo = mid+1;
        }
    }
    int last = -1;
    lo = 0, hi = n-1;
    while(lo<=hi){
        int mid = lo+(hi-lo)/2;
        if(arr[mid]==data){
            last = mid;
            lo = mid+1;
        }
        else if(arr[mid]>data){
            hi= mid-1;
        }
        else
            lo=mid+1;
    }
    cout<<"lb->"<<f<<" ub->";
    if(last==-1)
        cout<<lo;
    else
        cout<<last;
}












