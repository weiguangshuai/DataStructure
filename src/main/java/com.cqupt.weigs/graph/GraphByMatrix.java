package com.cqupt.weigs.graph;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class GraphByMatrix {
    //无向图标识
    public static final boolean UNDIRECTED_GRAPH = false;
    //有向图标识
    public static final boolean DIRECTED_GRAPH = true;

    //邻接矩阵实现
    public static final boolean ADJACENCY_MATRIX = true;
    //邻接表实现
    public static final boolean ADJACENCY_LIST = false;

    public static final int MAX_VALUE = Integer.MAX_VALUE;

    private boolean graphType;
    private boolean method;
    private int vertexSize;
    private int matrixMaxVertex;

    //存储所有顶点信息的一维数组
    private Object[] vertexesArray;
    //存储图中顶点之间关联关系的二维数组，及边的关系
    private int[][] edgesMatrix;

    //记录第i个节点是否被访问过
    private boolean[] visited;


    public GraphByMatrix(boolean graphType, boolean method, int size) {
        this.graphType = graphType;
        this.method = method;
        this.vertexSize = 0;
        this.matrixMaxVertex = size;

        if (method) {
            visited = new boolean[matrixMaxVertex];
            vertexesArray = new Object[matrixMaxVertex];
            edgesMatrix = new int[matrixMaxVertex][matrixMaxVertex];

            //对数组进行初始化，顶点间没有边关联的值为Integer类型的最大值
            for (int i = 0; i < edgesMatrix.length; i++) {
                for (int j = 0; j < edgesMatrix.length; j++) {
                    edgesMatrix[i][j] = MAX_VALUE;
                }
            }
        }


    }


    //添加顶点
    public boolean addVertex(Object val) {
        assert (val != null);
        vertexesArray[vertexSize] = val;
        vertexSize++;
        return true;
    }

    //添加边
    public boolean addEdge(int vnum1, int vnum2) {
        assert (vnum1 >= 0 && vnum2 >= 0 && vnum1 != vnum2);

        //有向图
        if (graphType) {
            edgesMatrix[vnum1][vnum2] = 1;
        } else {
            edgesMatrix[vnum1][vnum2] = 1;
            edgesMatrix[vnum2][vnum1] = 1;
        }
        return true;
    }

}
