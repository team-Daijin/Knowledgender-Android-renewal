package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import site.algosipeosseong.designsystem.theme.BasePurple
import site.algosipeosseong.designsystem.theme.DarkestBlack
import site.algosipeosseong.designsystem.theme.LighterBlack
import site.algosipeosseong.designsystem.theme.LighterPurple
import site.algosipeosseong.designsystem.theme.pretendard

@Composable
fun BaseDialog(
    openDialogCustom: MutableState<Boolean>,
    onLoginRequested: () -> Unit,
    title: String,
    description: String
) {
    Dialog(onDismissRequest = { openDialogCustom.value = false }) {
        DialogView(
            openDialogCustom = openDialogCustom,
            onLoginRequested = onLoginRequested,
            title = title,
            des = description
        )
    }
}

@Composable
private fun DialogView(
    onLoginRequested: () -> Unit,
    openDialogCustom: MutableState<Boolean>,
    title: String,
    des: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 0.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            BaseText(
                modifier = Modifier.padding(top = 32.dp),
                text = title,
                color = DarkestBlack,
                style = TextStyle(
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            )
            BaseText(
                modifier = Modifier.padding(top = 8.dp),
                text = des,
                color = LighterBlack,
                style = TextStyle(
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )
            Row(modifier = Modifier.padding(top = 24.dp)) {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(bottomStart = 16.dp),
                    colors = ButtonDefaults.buttonColors(LighterPurple),
                    onClick = { openDialogCustom.value = false },
                    contentPadding = PaddingValues(1.dp)
                ) {
                    BaseText(
                        text = "취소",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    )
                }
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(bottomEnd = 16.dp),
                    colors = ButtonDefaults.buttonColors(BasePurple),
                    onClick = {
                        onLoginRequested.invoke()
                        openDialogCustom.value = false
                    },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    BaseText(
                        text = "확인",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}