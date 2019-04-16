import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.UnknownFormatConversionException;

public class MySequencelmpl implements ISequence{
    private Object[] elem;
    private int usedSize;
    //默认的顺序表的容量
    private static final int DEFAULT_SIZE=10;
    public MySequencelmpl(){
        this.elem=new Object[DEFAULT_SIZE];
        this.usedSize=0;
    }
    public boolean isFull(){
        int pos=elem.length;
        if (this.usedSize==this.elem.length){
            return true;
        }return false;
    }
    @Override
    public boolean add(int pos, Object data) {
        //1、pos的合法性   2、是否是满的顺序表
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        if (isFull()) {
            //让数组扩大原长度的2倍
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    @Override
    public int search(Object key) {
        if (key==null){
            return -1;
        }
        if (isEmpty()){
            throw new UnknownFormatConversionException("顺序表为空");
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if (key==null){
            return false;
        }
        if (isEmpty()){
            throw new UnknownFormatConversionException("顺序表为空");
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if (pos<0|pos>=this.usedSize||isEmpty()){
            return null;
        }
        return this.elem[pos];
    }
    //删除之前，保存需要删除的值作为返回值
    @Override
    public Object remove(Object key) {
        int index=search(key);
        if (index==-1){
            return null;
        }
        Object oldDate=this.elem[index];
        int i=0;
        for (i=index; i <this.usedSize-1 ; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.elem[i+1]=null;
        this.usedSize--;
        return oldDate;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elem[i]=null;
        }
        this.usedSize=0;
    }
}
