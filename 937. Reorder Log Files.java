class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
	

		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				// TODO Auto-generated method stub

                
                
				String[] o1 = str1.split(" ", 2);
				String[] o2 = str2.split(" ", 2);

//                 System.out.println(o1[1]);
//                 System.out.println(o2[1]);
                
//                 System.out.println(o1[1].matches("[\\d ]+"));
//                 System.out.println(o2[1].matches("[\\d ]+"));
                
				if (o1[1].matches("[\\d ]+") && o2[1].matches("[\\d ]+")) {
                    // System.out.println("both numbers");
					return 0;
				} else if (o1[1].matches("[\\d ]+")) {
                    // System.out.println("first numbers");
					return 1;
				} else if (o2[1].matches("[\\d ]+")) {
                    // System.out.println("second numbers");
					return -1;
				} else {
                    // System.out.println("both string");
					int compared = o1[1].compareTo(o2[1]);
					if (compared == 0) {
						return o1[0].compareTo(o2[0]);
					} else
						return compared;
				}
			}
		};

		Arrays.sort(logs, comparator);

		return logs;
	}
}