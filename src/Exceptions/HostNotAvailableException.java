/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

public class HostNotAvailableException extends Exception{
     public HostNotAvailableException(String hostcomp) {
            super(hostcomp);
        }
    }
