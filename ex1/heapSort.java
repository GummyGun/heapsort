package t4.ex1;

public class heapSort {
    public static void main(String[] args) {
        int[] ar=randomArray(6,10,10);
        String[] arrName=new String[]{"carlos","carlo","carl","car","ca","c","q","r","t","rex","u"};
        Borrego arr[]= new Borrego[ar.length];
        for(int a=0; a<ar.length; a++){
            arr[a]=new Borrego(ar[a],arrName[a%11]);
        }
        /*
        printArr(arr);
        maxHeapify(arr, 0,arr.length-1);
         */
        System.out.println("pre-ordenamineto");
        printArr(arr);
        heapsort(arr);
        System.out.println("post-ordenamineto");
        printArr(arr);

    }
    private static <T extends Comparable<? super T>> boolean greaterThan(T a, T b){
        return (a.compareTo(b)) > 0;
    }
    private static int left(int k){
        return k*2+1;
    }
    private static int right(int k){
        return k*2+2;
    }
    private static int father(int k){
        return (k-1)/2;
    }

    private static int random (int min, int max) {
        return min + (int) ((max - min + 1) * Math.random());
    }

    private static int[] randomArray (int N, int min, int max) {
        int[] array = new int[N];
        for(int i = 0; i < N; i ++) array[i] = random (min, max);
        return array;
    }

    private static <T extends Comparable<? super T>> int exchangefather(T arr[], int k){
        int father=father(k);
//        System.out.printf("%d %d\n", k, father);
        if(k%2==1){
            if(greaterThan(arr[k],arr[father])){
                swap(arr, k, father);
            }
            return 0;
        }else{
            if(greaterThan(arr[k],arr[k-1])) {
                if(greaterThan(arr[k],arr[father])){

                    swap(arr, k, father);
                    return 1;
                }
                return 0;
            }else{
                if(greaterThan(arr[k-1],arr[father])){
                    swap(arr, k-1, father);
                    return -1;
                }
                return 0;

            }
        }
    }
    private static <T extends Comparable<? super T>> void createHeap(T arr[]){
        int guide=arr.length-1;
        int decrement=(guide%2==0)?2:1;
//        System.out.printf("%d\n", decrement);
        int state;
        while(guide>0){
            state=exchangefather(arr,guide);
            if(state==-1){
                maxHeapify(arr, guide-1, arr.length);
            }else if(state==1){
                maxHeapify(arr, guide, arr.length);
            }
            guide-=decrement;
            if(decrement==1){
                decrement++;
            }
//            break;
        }
    }
    private static <T extends Comparable<? super T>> void maxHeapify(T a[], int root, int heapSize){
        int right, left, pivot=root, big;
//        System.out.printf("hola amika\n");
        while(pivot<=heapSize){
            left=left(pivot);
            right=right(pivot);
//            System.out.printf("head %d limit %d left %d right %d// \n", pivot, heapSize, left, right);
            if(left<heapSize){
                if(right<heapSize){
                    if(greaterThan(a[right],a[left])){
                        big=right;
                    }else{
                        big=left;
                    }
                }else{
                    big=left;
                }
            }else{
                return;
            }
            if(greaterThan(a[big], a[pivot])){
                swap(a, pivot, big);
                pivot=big;
            }else{
                return;
            }
        }
    }

    private static <T extends Comparable<? super T>> void swap(T arr[], int arg1, int arg2){
        T tmp= arr[arg1];
        arr[arg1]=arr[arg2];
        arr[arg2]=tmp;
    }

    private static <T extends Comparable<? super T>> void heapsort(T a[]){
        createHeap(a);
        for(int iter=a.length-1; iter>0; iter--){
            swap(a, 0, iter);
            maxHeapify(a, 0, iter);
        }
    }

     private static <T extends Object> void printArr(T[] array){
        for(T value: array){
            System.out.println(value);
        }
        System.out.println();
    }
}
