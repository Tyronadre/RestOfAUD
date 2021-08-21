package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;

public class GuiPanel extends JPanel {
    protected KarelWorld world;

    public GuiPanel(KarelWorld world) {
        this.world = world;
        this.setSize(this.getPreferredSize());
    }

    protected Dimension getUnscaledSize() {
        Point p = PaintUtils.getBoardSize(this.world);
        return new Dimension(p.x + 40, p.y + 40);
    }

    public Dimension getPreferredSize() {
        return getUnscaledSize();
    }

    public void paintComponent(Graphics g) {
        Image image = new BufferedImage(this.getUnscaledSize().width, this.getUnscaledSize().height, 2);
        Graphics gImage = image.getGraphics();
        draw(gImage);
        if (this.getWidth() != this.getUnscaledSize().width || this.getHeight() != this.getUnscaledSize().height) {
            image = image.getScaledInstance(this.getWidth(), this.getHeight(), 4);
        }

        g.drawImage(image, 0, 0, null);
    }

    protected void draw(Graphics g) {
        drawBoard(g);
        LinkedList<FieldEntity> entities = this.world.getAllFieldEntities();
        Iterator var5 = entities.iterator();

        for (var entity : world.getAllFieldEntities()) {
            if (entity instanceof Block)
                drawBlock((Block) entity, g);
            else {
                System.err.println("Could not draw FieldEntity of Type: " + entity);
            }

        }
    }

    protected void drawBoard(Graphics g) {
        //Hintergrund Schwarz
        int width = 20;
        int height = 20;
        g.setColor(Color.BLACK);
        Point p = PaintUtils.getBoardSize(this.world);
        g.fillRect(width, height, p.x, p.y);
        width = 24;
        height = 24;
        //Inneres Grau
        g.setColor(Color.GRAY);
        g.fillRect(width, height, p.x - 8, p.y - 8);
        g.setColor(Color.LIGHT_GRAY);

        for (int h = 0; h < world.getHeight(); h++) {
            for (int w = 0; w < world.getWidth(); w++) {
                g.fillRect(width, height, PaintUtils.FIELD_INNER_SIZE, PaintUtils.FIELD_INNER_SIZE);
                if (h == 99) {
                    g.setColor(Color.GREEN);
                    g.drawString(width + ";" + height, width, height);
                    g.setColor(Color.LIGHT_GRAY);
                }

                width += PaintUtils.FIELD_INNER_SIZE + PaintUtils.FIELD_BORDER_THICKNESS;
            }

            width = PaintUtils.BOARD_OFFSET + PaintUtils.FIELD_BORDER_THICKNESS;
            height += PaintUtils.FIELD_INNER_SIZE + PaintUtils.FIELD_BORDER_THICKNESS;
        }
    }

    protected void drawBlock(Block b, Graphics g) {
        Color cBackup = g.getColor();
        Point upperLeft = PaintUtils.getUpperLeftCornerInField(b, this.world.getHeight());
        g.setColor(Color.BLACK);
        int size = 52;
        g.fillRect(upperLeft.x, upperLeft.y, size, size);
        g.setColor(cBackup);
    }

    public void updateGui() {
        if (SwingUtilities.isEventDispatchThread()) {
            this.revalidate();
            this.repaint();
        } else {
            Runnable r = () -> {
                GuiPanel.this.revalidate();
                GuiPanel.this.repaint();
            };
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException | InvocationTargetException e){
                e.printStackTrace();
            }
            Toolkit.getDefaultToolkit().sync();
        }
    }
}
