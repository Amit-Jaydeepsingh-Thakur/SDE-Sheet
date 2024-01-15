class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        boolean[][] vis = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        Character c = ' ';
        
        if (m[n-1][n-1] == 0 || m[0][0] == 0) {
            return ans;
        }
        
        solve(ans, sb, m, vis, 0, 0, c);
        
        return ans;
    }
    
    public static void solve(ArrayList<String> ans, StringBuffer sb, int[][] m, boolean[][] vis, int i, int j, Character c) {
        
        if (i < 0 || j < 0 || i >= m[0].length || j >= m.length || vis[i][j] || m[i][j] == 0) {
            return;
        }
        
        if (i == m.length - 1 && j == m[0].length - 1) {
            sb.append(c);
            ans.add(sb.toString().trim());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        
        vis[i][j] = true;
        sb.append(c);
        
        solve(ans, sb, m, vis, i+1, j, 'D');
        solve(ans, sb, m, vis, i-1, j, 'U');
        solve(ans, sb, m, vis, i, j+1, 'R');
        solve(ans, sb, m, vis, i, j-1, 'L');
        
        vis[i][j] = false;
        
        
        sb.deleteCharAt(sb.length() - 1);
        
        
        return;
    }
    
}
