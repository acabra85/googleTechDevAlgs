package com.acabra.gtechdevalgs.litcode.geometry;

public class RectangleSol {

    public static void main(String[] args) {
        System.out.println("true: " + isRectangleOverlap(
                new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20})
        );
        System.out.println("false: " + isRectangleOverlap(
                new int[]{0,0,1,1}, new int[]{1,0,2,1})
        );
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Rectangle.of(rec1).overlaps(Rectangle.of(rec2));
    }

    private static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Rectangle {
        final Point bot;
        final Point top;
        private final boolean noArea;

        public Rectangle(Point bot, Point top) {
            this.bot = bot;
            this.top = top;
            this.noArea = bot.x == top.x || bot.y == top.y;
        }

        static Rectangle of(int[] r1) {
            return new Rectangle(
                    new Point(r1[0], r1[1]),
                    new Point(r1[2], r1[3]));
        }

        public boolean overlaps(Rectangle other) {
            return !doesNotOverlap(other);
        }

        private boolean doesNotOverlap(Rectangle other) {
            return this.noArea || other.noArea
                || this.aboveOrBelow(other) || this.toLeftOrRight(other);
        }

        private boolean toLeftOrRight(Rectangle other) {
            return this.top.x <= other.bot.x // left
             || this.bot.x >= other.top.x; // right;
        }

        private boolean aboveOrBelow(Rectangle other) {
            return this.bot.y >= other.top.y // above
                    || this.top.y <= other.bot.y; // below;
        }
    }
}
