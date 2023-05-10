
import java.util.ArrayList;

public class VideoCardTree {
    private Video_Cards videoCard;
    private VideoCardTree left;

    private VideoCardTree right;
    public VideoCardTree(Video_Cards... videoCards) {
        for (Video_Cards videoCard : videoCards) {
            this.addVideoCards(videoCard);
        }
    }

    public void addVideoCards(Video_Cards videoCard) {
        if (this.videoCard == null) {
            this.videoCard = videoCard;
            return;
        }

        if (videoCard.getProduct_code() > this.videoCard.getProduct_code()) {
            if (this.right == null) {
                this.right = new VideoCardTree(videoCard);
            } else {
                this.right.addVideoCards(videoCard);
            }
        } else if (videoCard.getProduct_code() < this.videoCard.getProduct_code()) {
            if (this.left == null) {
                this.left = new VideoCardTree(videoCard);
            } else {
                this.left.addVideoCards(videoCard);
            }
        }
    }

    public Video_Cards findVideoCardByCode(int product_code) {
        if (this.videoCard == null) {
            throw new IllegalStateException("There is no Videocard with such product_code");
        }
        if (product_code > this.videoCard.getProduct_code()) {
            return this.right.findVideoCardByCode(product_code);
        } else if (product_code < this.videoCard.getProduct_code()) {
            return this.left.findVideoCardByCode(product_code);
        } else {
            return this.videoCard;
        }
    }

    public void removeVideoCard(int product_code) {
        if (this.videoCard == null) {
            throw new IllegalStateException("There is no VideoCard with such product_code");
        }
        if (product_code > this.videoCard.getProduct_code()) {
            if (this.right != null) {
                this.right.removeVideoCard(product_code);
            }
        } else if (product_code < this.videoCard.getProduct_code()) {
            if (this.left != null) {
                this.left.removeVideoCard(product_code);
            }
        } else {
            if (this.left == null && this.right == null) {
                this.videoCard = null;
            } else if (this.left == null) {
                this.videoCard = this.right.videoCard;
                this.left = this.right.left;
                this.right = this.right.right;
            } else if (this.right == null) {
                this.videoCard = this.left.videoCard;
                this.right = this.left.right;
                this.left = this.left.left;
            } else {
                VideoCardTree leftMost = this.right.getLeftmost();
                this.videoCard = leftMost.videoCard;
                this.right.removeVideoCard(leftMost.videoCard.getProduct_code());
            }
        }
    }

    public VideoCardTree getLeftmost() {
        if (this.left == null) {
            return this;
        }
        return this.left.getLeftmost();
    }

    public void preorder() {
        if (this.videoCard == null) {
            return;
        }
        System.out.println(this.videoCard);
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }

    public void inorder() {
        if (this.videoCard == null) {
            return;
        }
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.println(this.videoCard);
        if (this.right != null) {
            this.right.inorder();
        }
    }

    public void postorder() {
        if (this.videoCard == null) {
            return;
        }
        if (this.left != null) {
            this.left.postorder();
        }
        if (this.right != null) {
            this.right.postorder();
        }
        System.out.println(this.videoCard);
    }

    public Video_Cards getVideoCard() {
        return videoCard;
    }

    public VideoCardTree getLeft() {
        return left;
    }

    public VideoCardTree getRight() {
        return right;
    }
}