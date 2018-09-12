class Date {
  /*
  task
  given a date
  return the weekday of that date
  */
  public static void main(String[] args) {
    // create a method
    public static String getDay(String day, String month, String year) {
      // use the Calendar class
      Calendar c = Calendar.getInstance();
      // we need to set the year month and day, the month requried -1
      c.set(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day));
      // we get the weekday, the retunr is 1-7 = sunday to saturday
      int i=c.get(Calendar.DAY_OF_WEEK);
      String weekdays[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
      return weekdays[i-1].toUpperCase();
  }
}
