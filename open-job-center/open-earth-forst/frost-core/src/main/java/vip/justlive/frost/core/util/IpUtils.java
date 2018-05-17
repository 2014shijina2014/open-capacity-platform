package vip.justlive.frost.core.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * ip工具类
 * 
 * @author wubo
 *
 */
public class IpUtils {

  IpUtils() {}

  public static final String SEPERATOR = ":";
  public static final String LOCALHOST = "localhost";

  /**
   * 获取本机ip
   * 
   * @return
   * @throws SocketException
   */
  public static String ip() {
    // 本地IP
    Enumeration<NetworkInterface> netInterfaces;
    try {
      netInterfaces = NetworkInterface.getNetworkInterfaces();
    } catch (SocketException e) {
      // nothing
      return LOCALHOST;
    }
    InetAddress ip = null;
    while (netInterfaces.hasMoreElements()) {
      NetworkInterface ni = netInterfaces.nextElement();
      Enumeration<InetAddress> address = ni.getInetAddresses();
      while (address.hasMoreElements()) {
        ip = address.nextElement();
        if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
            && ip.getHostAddress().indexOf(SEPERATOR) == -1) {
          // 内网IP
          return ip.getHostAddress();
        }
      }
    }
    return LOCALHOST;
  }

}
