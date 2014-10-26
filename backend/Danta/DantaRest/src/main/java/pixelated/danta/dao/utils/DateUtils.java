/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Juan Carlos Rojas
 */
public class DateUtils {
    
    private static final int TIME_ZONE_OFFSET = -6;
    
    public static String formatDate(Date date) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yy");
        simpleFormat.setTimeZone( TimeZone.getTimeZone("GMT" + TIME_ZONE_OFFSET + ":00") );
        return simpleFormat.format(date);
    }
    
}
