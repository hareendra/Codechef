package codechef;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Apartment {
    private ArrayList<Customer> customers=new ArrayList<Customer>();
    int id; //Not used ,as array subscript is itself used as id

    public void addCustomer(Customer c) {
        customers.add(c);
    }
    public int calcMaxCustomers() {
        Collections.sort(customers);

        int max=1;

        Customer last=customers.get(0);
        for (int i=1;i<customers.size();i++) {
            if (last.f <= customers.get(i).s) {
                max++;
                last=customers.get(i);
            }
        }
        return max;
    }
}

class Customer implements Comparable<Customer>{
    //[s,f)
    int s; //inclusive
    int f; //excluding

    public Customer(int s,int f) {
        this.s=s;
        this.f=f;
    }
    public int compareTo(Customer c) {
        if(this.f==c.f) {
            return 0;
        }else if(this.f<c.f) {
            return -1;
        }else {
            return 1;
        }
    }
}


public class FGFS {
    public static void main (String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//new BufferedReader(new FileReader("in.txt"));
        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++) {
            String[] strAry=in.readLine().split(" ");
            int n=Integer.parseInt(strAry[0]);
            int k=Integer.parseInt(strAry[1]);

            Apartment[] apartments=new Apartment[k];
            for(int j=0;j<k;j++) {
                apartments[j]=new Apartment();
            }

            for(int j=0;j<n;j++) {
                strAry=in.readLine().split(" ");
                int s=Integer.parseInt(strAry[0]);
                int f=Integer.parseInt(strAry[1]);
                int p=Integer.parseInt(strAry[2]);

                apartments[p-1].addCustomer(new Customer(s,f));
            }

            int max=0;
            for(int j=0;j<k;j++) {
                max+=apartments[j].calcMaxCustomers();
            }
            System.out.println(max);
        }
    }

}
