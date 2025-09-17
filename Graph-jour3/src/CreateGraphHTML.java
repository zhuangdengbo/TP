import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateGraphHTML {
    public static void main(String[] args) {
        try {
            File htmlFile = new File("graph.html");
            FileWriter writer = new FileWriter(htmlFile);

            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n<head>\n<title>Graph Visualization</title>\n</head>\n<body>\n");
            writer.write("<h2>Graph Visualization</h2>\n");
            writer.write("<svg width='500' height='500'>\n");

            int r = 20; // 圆半径

            // 节点坐标
            int[][] nodes = {
                    {100, 100}, // A
                    {200, 100}, // B
                    {150, 200}, // C
                    {300, 200}  // D
            };
            String[] labels = {"A", "B", "C", "D"};
            String[] colors = {"lightblue", "lightgreen", "lightpink", "lightyellow"};

            // 绘制节点
            for (int i = 0; i < nodes.length; i++) {
                int cx = nodes[i][0];
                int cy = nodes[i][1];
                writer.write("<circle cx='" + cx + "' cy='" + cy + "' r='" + r + "' fill='" + colors[i] + "' stroke='black' stroke-width='2'/>\n");
                writer.write("<text x='" + cx + "' y='" + (cy + 5) + "' text-anchor='middle' font-size='15'>" + labels[i] + "</text>\n");
            }

            // 边定义 (节点索引)
            int[][] edges = {
                    {0, 1}, // A-B
                    {0, 2}, // A-C
                    {1, 2}, // B-C
                    {1, 3}  // B-D
            };

            // 绘制边（从圆边缘开始）
            for (int[] edge : edges) {
                int i = edge[0];
                int j = edge[1];

                double dx = nodes[j][0] - nodes[i][0];
                double dy = nodes[j][1] - nodes[i][1];
                double dist = Math.sqrt(dx * dx + dy * dy);

                double x1 = nodes[i][0] + dx / dist * r;
                double y1 = nodes[i][1] + dy / dist * r;
                double x2 = nodes[j][0] - dx / dist * r;
                double y2 = nodes[j][1] - dy / dist * r;

                writer.write("<line x1='" + x1 + "' y1='" + y1 + "' x2='" + x2 + "' y2='" + y2 + "' stroke='black' stroke-width='2'/>\n");
            }

            writer.write("</svg>\n");
            writer.write("</body>\n</html>");

            writer.close();
            System.out.println("HTML graph created successfully at: " + htmlFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}



