/*
 * This file KitTest is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 19:13 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import bzh.strawberry.kits.StrawKits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private ServerMock server;
    private StrawKits plugin;

    @Before
    public void setUp() {
        server = MockBukkit.mock();
        plugin = (StrawKits) MockBukkit.load(StrawKits.class);
    }

    @After
    public void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    public void testPlayerJoin() {
        PlayerMock playerMock = server.addPlayer();
    }

}