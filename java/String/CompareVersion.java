package String;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int l=Math.min(v1.length,v2.length);
        for(int i=0;i<l;++i){
            int x=comp(v1[i],v2[i]);
            if(x==0) continue;
            return x;
        }
        if(v1.length>l){
            for(int i=l;i<v1.length;++i){
                if(str2int(v1[i])==0) continue;
                return 1;
            }
        }
        if(v2.length>l){
            for(int i=l;i<v2.length;++i){
                if(str2int(v2[i])==0) continue;
                return -1;
            }
        }
        return 0;
    }

    public int comp(String s1,String s2){
            int x=str2int(s1);
            int y=str2int(s2);
            if(x==y) return 0;
            else if(x<y) return -1;
            else return 1;
    }

    public int str2int(String s){
        int ans=0;
        for(int i=0;i<s.length();++i){
            ans=(ans*10+(s.charAt(i)-'0'));//不受前导0影响
        }
        return ans;
    }

    public static void main(String[] args) {
        CompareVersion cv = new CompareVersion();
        // String version1 = "1.0.1";
        // String version2 = "1.0.2";
        // System.out.println("Comparison Result: " + cv.compareVersion(version1, version2)); // Output: -1

        String version1 = "1";
        String version2 = "0";
        System.out.println("Comparison Result: " + cv.compareVersion(version1, version2)); // Output: 0

        version1 = "1.02";
        version2 = "1.001";
        System.out.println("Comparison Result: " + cv.compareVersion(version1, version2)); // Output: 0
    }
}
