package oit.is.z0846.kaizi.janken.model;

public class Janken {
  public String me;
  public String you;
  public String j;

  public Janken(String me) {
    this.me = me;
    this.you = "Gu";

    if (this.me.equals("Gu")) {
      this.j = "Draw";
    }
    if (this.me.equals("Choki")) {
      this.j = "You lose";
    }
    if (this.me.equals("Pa")) {
      this.j = "You Win!";
    }
  }
}
