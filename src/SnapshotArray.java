import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SnapshotArray {
    List<List<int[]>> mylist=new LinkedList<>();
    int id=0;
    public SnapshotArray(int length) {
        for (int i=0;i<length;i++)
        {
            List<int[]>temp=new ArrayList<>();
            temp.add(new int[]{0,0});
            mylist.add(temp);
        }
    }

    public void set(int index, int val) {
        List<int[]>temp=mylist.get(index);
        if (temp.get(temp.size()-1)[0]==id)
            temp.get(temp.size()-1)[1]=val;
        else
            mylist.get(index).add(new int[]{id,val});
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        List<int[]>temp=mylist.get(index);
        int low =0;
        int high=temp.size()-1;
        while (low<=high)
        {
            int mid=high-(high-low)/2;
            if (temp.get(mid)[0]==snap_id)
                return temp.get(mid)[1];
            if(temp.get(mid)[0]<snap_id)
                low=mid+1;
            else
                high=mid-1;
        }
        return  temp.get(low-1)[1];
    }
}