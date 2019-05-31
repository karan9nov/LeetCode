class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<String> sbs = new ArrayList<>();
        List<Integer> retval = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            
            boolean contains = false;
            int start = 0;
            for (;start < sbs.size(); start++) {
                if (sbs.get(start).contains(String.valueOf(S.charAt(i)))) {
                    contains = true;
                    break;
                }
            }
            
            sbs.add(String.valueOf(S.charAt(i)));
            if (contains) {
                String result = merge(sbs, start);
                sbs.add(result);
            }
        }
        
        for (String s: sbs)
            retval.add(s.length());
        
        return retval;
    }
    
    private String merge(List<String> list, int start) {
        
        StringBuilder sb = new StringBuilder();
        
        while (start < list.size()) {
            sb.append(list.get(start));
            list.remove(start);
        }
        
        return sb.toString();
    }
}