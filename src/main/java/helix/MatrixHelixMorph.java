package helix;

public class MatrixHelixMorph {
    public static int[][] helix(int[][] in) {
        if (in == null || in.length == 1) return in;
        int xSize = in[0].length, ySize = in.length, dir = 0;
        int[][] out = in.clone(), dirs = {{0,1,ySize-1,-1},{-1,0,0,1 },{0,-1,1,1},{1,0,xSize-1,-1}};
        for (int y = 0; y < ySize; y++) out[y] = in[y].clone();
        int[] xy = { xSize - 1, 1 }, newxy;
        for (int fromY = 1; fromY < ySize; fromY++) {
            for (int fromX = 0; fromX < xSize; fromX++,xy=newxy) {
                out[xy[1]][xy[0]] = in[fromY][fromX];
                newxy = new int[]{xy[0] + dirs[dir][0],xy[1] + dirs[dir][1]};
                if (dirs[dir][3]==1 ? newxy[(dir+1)%2]<dirs[dir][2] : newxy[(dir+1)%2]>dirs[dir][2]) {
                    dirs[(dir+3)%4][2] += dirs[(dir+3)%4][3];
                    dir = (dir+1)%4;
                    newxy = new int[]{xy[0]+dirs[dir][0],xy[1]+dirs[dir][1]};
                }
            }
        }
        return out;
    }
}