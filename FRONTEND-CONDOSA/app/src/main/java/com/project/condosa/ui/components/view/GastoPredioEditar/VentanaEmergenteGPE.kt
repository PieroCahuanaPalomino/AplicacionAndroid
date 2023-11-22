package com.project.condosa.ui.components.view.GastoPredioEditar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.project.condosa.R

@Composable
fun GastoPredioeditar(modifier: Modifier = Modifier) {
    TopLevel(modifier = modifier) {
        Group7 {
            Rectangle53(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 0.0.dp
                    )
                )
            )
            EditarGasto(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = -146.0.dp
                    )
                )
            )
            Frame8(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 14.0.dp
                    )
                )
            ) {
                Group2 {
                    Frame1(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 8.0.dp
                            )
                        )
                    ) {
                        Frame1Synth {
                            Rectangle45()
                        }
                    }
                    TITULO(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 69.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                    Line8(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 65.74365234375.dp,
                                y = 56.75.dp
                            )
                        )
                    )
                    FrameElegirOpciones(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 56.0.dp,
                                y = 16.0.dp
                            )
                        )
                    ) {
                        SeleccionaUnaOpciN()
                        ChevronDownOutline {
                            Vector2(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = -0.75.dp,
                                        y = -0.75.dp
                                    )
                                )
                            )
                        }
                    }
                }
            }
            Frame9(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = 91.0.dp
                    )
                )
            ) {
                Group3 {
                    Frame2(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 8.0.dp
                            )
                        )
                    ) {
                        Frame1Synth1 {
                            Rectangle46()
                        }
                    }
                    TITULO1(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 69.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                    Line9(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 65.74365234375.dp,
                                y = 56.75.dp
                            )
                        )
                    )
                    FrameElegirOpciones1(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 56.0.dp,
                                y = 16.0.dp
                            )
                        )
                    ) {
                        SeleccionaUnaOpciN1()
                    }
                }
            }
            Frame7(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 0.0.dp,
                        y = -70.0.dp
                    )
                )
            ) {
                Group4 {
                    Frame3(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 8.0.dp
                            )
                        )
                    ) {
                        Frame1Synth2 {
                            Rectangle47()
                        }
                    }
                    TITULO2(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 69.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                    Line10(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 65.74365234375.dp,
                                y = 56.75.dp
                            )
                        )
                    )
                    FrameElegirOpciones2(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 56.0.dp,
                                y = 16.0.dp
                            )
                        )
                    ) {
                        SeleccionaUnaOpciN2()
                        ChevronDownOutline2 {
                            Vector6(
                                modifier = Modifier.boxAlign(
                                    alignment = Alignment.TopStart,
                                    offset = DpOffset(
                                        x = -0.75.dp,
                                        y = -0.75.dp
                                    )
                                )
                            )
                        }
                    }
                }
            }
            IconHandHoldingUSDollar(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 51.0.dp,
                        y = 246.0.dp
                    )
                )
            ) {
                Vector7(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.0.dp
                        )
                    )
                )
            }
            Cost(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = -110.0.dp,
                        y = -84.0.dp
                    )
                )
            )
            Vector(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = -111.5.dp,
                        y = 3.0.dp
                    )
                )
            )
            Boton(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = 65.5.dp,
                        y = 145.5.dp
                    )
                )
            ) {
                Rectangle44(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Boton2(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.5.dp
                        )
                    )
                )
            }
            Boton1(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.Center,
                    offset = DpOffset(
                        x = -68.5.dp,
                        y = 145.5.dp
                    )
                )
            ) {
                Rectangle48(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Boton3(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.Center,
                        offset = DpOffset(
                            x = 0.0.dp,
                            y = 0.5.dp
                        )
                    )
                )
            }
        }
    }
}

@Preview(widthDp = 356, heightDp = 371)
@Composable
private fun GastoPredioeditarPreview() {
    MaterialTheme {
        RelayContainer {
            GastoPredioeditar(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun Rectangle53(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_53),
        modifier = modifier.requiredWidth(318.0.dp).requiredHeight(371.0.dp)
    )
}

@Composable
fun EditarGasto(modifier: Modifier = Modifier) {
    RelayText(
        content = "Editar Gasto",
        fontSize = 18.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        modifier = modifier
    )
}

@Composable
fun Rectangle45(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_45),
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun Frame1Synth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp).alpha(alpha = 100.0f)
    )
}

@Composable
fun Frame1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun TITULO(modifier: Modifier = Modifier) {
    RelayText(
        content = "DESCRIPCIÓN",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(182.0.dp).requiredHeight(16.0.dp)
    )
}

@Composable
fun Line8(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_line_8),
        modifier = modifier.requiredWidth(190.62498474121094.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun SeleccionaUnaOpciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Planilla",
        fontSize = 12.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 137,
            green = 138,
            blue = 141
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(171.0.dp)
    )
}

@Composable
fun Vector2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_vector1),
        modifier = modifier.requiredWidth(13.5.dp).requiredHeight(6.75.dp)
    )
}

@Composable
fun ChevronDownOutline(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 5.0.dp,
            top = 6.0.dp,
            end = 5.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun FrameElegirOpciones(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 10.0.dp,
            top = 11.0.dp,
            end = 17.0.dp,
            bottom = 16.0.dp
        ),
        clipToParent = false,
        radius = 8.0,
        strokeWidth = 1.0,
        content = content,
        modifier = modifier.requiredWidth(215.5.dp).requiredHeight(34.0.dp)
    )
}

@Composable
fun Group2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(271.5.dp).requiredHeight(57.0.dp)
    )
}

@Composable
fun Frame8(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 44.0.dp,
            top = 9.0.dp,
            end = 23.0.dp,
            bottom = 1.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(356.0.dp).requiredHeight(99.0.dp)
    )
}

@Composable
fun Rectangle46(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_46),
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun Frame1Synth1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp).alpha(alpha = 100.0f)
    )
}

@Composable
fun Frame2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun TITULO1(modifier: Modifier = Modifier) {
    RelayText(
        content = "IMPORTE TOTAL",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(182.0.dp).requiredHeight(16.0.dp)
    )
}

@Composable
fun Line9(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_line_9),
        modifier = modifier.requiredWidth(190.62498474121094.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun SeleccionaUnaOpciN1(modifier: Modifier = Modifier) {
    RelayText(
        content = "100",
        fontSize = 13.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 137,
            green = 138,
            blue = 141
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(171.0.dp)
    )
}

@Composable
fun FrameElegirOpciones1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 10.0.dp,
            top = 11.0.dp,
            end = 17.0.dp,
            bottom = 16.0.dp
        ),
        clipToParent = false,
        radius = 8.0,
        strokeWidth = 1.0,
        content = content,
        modifier = modifier.requiredWidth(215.5.dp).requiredHeight(34.0.dp)
    )
}

@Composable
fun Group3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(271.5.dp).requiredHeight(57.0.dp)
    )
}

@Composable
fun Frame9(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 44.0.dp,
            top = 9.0.dp,
            end = 23.0.dp,
            bottom = 1.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(356.0.dp).requiredHeight(99.0.dp)
    )
}

@Composable
fun Rectangle47(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_47),
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun Frame1Synth2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp).alpha(alpha = 100.0f)
    )
}

@Composable
fun Frame3(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(46.0.dp).requiredHeight(46.0.dp)
    )
}

@Composable
fun TITULO2(modifier: Modifier = Modifier) {
    RelayText(
        content = "TIPO DE GASTO",
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(182.0.dp).requiredHeight(16.0.dp)
    )
}

@Composable
fun Line10(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_line_10),
        modifier = modifier.requiredWidth(190.62498474121094.dp).requiredHeight(0.0.dp)
    )
}

@Composable
fun SeleccionaUnaOpciN2(modifier: Modifier = Modifier) {
    RelayText(
        content = "Administrativo y Conta.",
        fontSize = 12.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 137,
            green = 138,
            blue = 141
        ),
        height = 1.5.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(600.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(171.0.dp)
    )
}

@Composable
fun Vector6(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_vector2),
        modifier = modifier.requiredWidth(13.5.dp).requiredHeight(6.75.dp)
    )
}

@Composable
fun ChevronDownOutline2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 5.0.dp,
            top = 6.0.dp,
            end = 5.0.dp,
            bottom = 6.0.dp
        ),
        itemSpacing = 10.0,
        content = content,
        modifier = modifier
    )
}

@Composable
fun FrameElegirOpciones2(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 10.0.dp,
            top = 11.0.dp,
            end = 17.0.dp,
            bottom = 16.0.dp
        ),
        clipToParent = false,
        radius = 8.0,
        strokeWidth = 1.0,
        content = content,
        modifier = modifier.requiredWidth(215.5.dp).requiredHeight(34.0.dp)
    )
}

@Composable
fun Group4(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(271.5.dp).requiredHeight(57.0.dp)
    )
}

@Composable
fun Frame7(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 44.0.dp,
            top = 9.0.dp,
            end = 23.0.dp,
            bottom = 1.0.dp
        ),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(356.0.dp).requiredHeight(99.0.dp)
    )
}

@Composable
fun Vector7(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_vector3),
        modifier = modifier.requiredWidth(36.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun IconHandHoldingUSDollar(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(36.0.dp).requiredHeight(37.0.dp)
    )
}

@Composable
fun Cost(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.gasto_predioeditar_cost),
        contentScale = ContentScale.Fit,
        modifier = modifier.requiredWidth(38.0.dp).requiredHeight(43.0.dp)
    )
}

@Composable
fun Vector(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_vector),
        modifier = modifier.requiredWidth(35.0.dp).requiredHeight(35.0.dp)
    )
}

@Composable
fun Rectangle44(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_44),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Boton2(modifier: Modifier = Modifier) {
    RelayText(
        content = "Actualizar",
        fontSize = 12.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272510528564.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    )
}

@Composable
fun Boton(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(109.0.dp).requiredHeight(32.0.dp)
    )
}

@Composable
fun Rectangle48(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.gasto_predioeditar_rectangle_48),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Boton3(modifier: Modifier = Modifier) {
    RelayText(
        content = "Cancelar",
        fontSize = 12.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272510528564.em,
        fontWeight = FontWeight(700.0.toInt()),
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    )
}

@Composable
fun Boton1(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(111.0.dp).requiredHeight(32.0.dp)
    )
}

@Composable
fun Group7(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(356.0.dp).requiredHeight(371.0.dp)
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}