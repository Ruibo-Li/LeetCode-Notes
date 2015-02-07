        int[] num = {1000,500,100,50,10,5,1};
        char[] rec = {'M','D','C','L','X','V','I'};
        int prev = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<rec.length;j++){
                if(s.charAt(i)==rec[j]){
                    res += num[j];
                    if(prev>j) res -= 2*num[prev];
                    prev = j;
                } 
            }
        }
        return res;