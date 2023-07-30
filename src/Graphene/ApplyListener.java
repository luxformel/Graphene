/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Graphene;

/**
 *
 * @author luxformel
 */
import java.util.EventListener;

public interface ApplyListener extends EventListener {
    void applyButtonClicked(ApplyEvent event);
}